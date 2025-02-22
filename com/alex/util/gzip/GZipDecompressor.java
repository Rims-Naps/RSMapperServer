//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.alex.util.gzip;

import com.alex.io.Stream;
import java.util.zip.Inflater;

public class GZipDecompressor {
    private static final Inflater inflaterInstance = new Inflater(true);

    public GZipDecompressor() {
    }

    public static final boolean decompress(Stream stream, byte[] data) {
        synchronized(inflaterInstance) {
            if (stream.getBuffer()[stream.getOffset()] == 31 && stream.getBuffer()[stream.getOffset() + 1] == -117) {
                try {
                    inflaterInstance.setInput(stream.getBuffer(), stream.getOffset() + 10, -stream.getOffset() - 18 + stream.getBuffer().length);
                    inflaterInstance.inflate(data);
                } catch (Exception var4) {
                    inflaterInstance.reset();
                    return false;
                }

                inflaterInstance.reset();
                return true;
            } else {
                return false;
            }
        }
    }
}
