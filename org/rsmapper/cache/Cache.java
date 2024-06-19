//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.cache;

import com.alex.store.Store;
import com.alex.util.whirlpool.Whirlpool;
import java.io.IOException;
import org.rsmapper.networking.codec.stream.OutputStream;

public final class Cache {
    public static Store STORE;

    private Cache() {
    }

    public static void init() throws IOException {
        STORE = new Store("data/cache/");
    }

    public static void main(String... args) throws IOException {
        init();
        StringBuilder bldr = new StringBuilder();
        int total = 0;
        byte[] var6;
        int var5 = (var6 = STORE.generateIndex255Archive255()).length;

        for(int var4 = 0; var4 < var5; ++var4) {
            byte b = var6[var4];
            bldr.append(b + ",");
            System.out.println(total += b);
        }

        System.out.println(bldr);
    }

    public static final byte[] generateUkeysFile() {
        OutputStream stream = new OutputStream();
        stream.writeByte(STORE.getIndexes().length);

        for(int index = 0; index < STORE.getIndexes().length; ++index) {
            if (STORE.getIndexes()[index] == null) {
                stream.writeInt(0);
                stream.writeInt(0);
                stream.writeBytes(new byte[64]);
            } else {
                stream.writeInt(STORE.getIndexes()[index].getCRC());
                stream.writeInt(STORE.getIndexes()[index].getTable().getRevision());
                stream.writeBytes(STORE.getIndexes()[index].getWhirlpool());
            }
        }

        byte[] archive = new byte[stream.getOffset()];
        stream.setOffset(0);
        stream.getBytes(archive, 0, archive.length);
        OutputStream hashStream = new OutputStream(65);
        hashStream.writeByte(0);
        hashStream.writeBytes(Whirlpool.getHash(archive, 0, archive.length));
        byte[] hash = new byte[hashStream.getOffset()];
        hashStream.setOffset(0);
        hashStream.getBytes(hash, 0, hash.length);
        stream.writeBytes(hash);
        archive = new byte[stream.getOffset()];
        stream.setOffset(0);
        stream.getBytes(archive, 0, archive.length);
        return archive;
    }
}
