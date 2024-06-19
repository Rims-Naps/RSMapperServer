//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.networking.protocol.js5;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.rsmapper.cache.Cache;
import org.rsmapper.networking.Session;
import org.rsmapper.networking.codec.Decoder;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.utilities.misc.ServerThreadFactory;

public final class GrabPacketsDecoder extends Decoder {
    private LinkedList<String> requests = new LinkedList();
    private static ExecutorService updateService = Executors.newFixedThreadPool(1);
    private static ExecutorService worker = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), new ServerThreadFactory("JS5-Worker"));

    public GrabPacketsDecoder(Session connection) {
        super(connection);
    }

    public final void decode(InputStream stream) {
        while(stream.getRemaining() > 0 && this.session.getChannel().isConnected()) {
            int packetId = stream.readUnsignedByte();
            this.decodeRequestCacheContainer(stream, packetId);
        }

        this.requests.clear();
    }

    private final void decodeRequestCacheContainer(InputStream stream, int priority) {
        final int indexId = stream.readUnsignedByte();
        final int archiveId = stream.readInt();
        if (archiveId >= 0) {
            if (indexId != 255) {
                if (Cache.STORE.getIndexes().length <= indexId || Cache.STORE.getIndexes()[indexId] == null || !Cache.STORE.getIndexes()[indexId].archiveExists(archiveId)) {
                    return;
                }
            } else if (archiveId != 255 && (Cache.STORE.getIndexes().length <= archiveId || Cache.STORE.getIndexes()[archiveId] == null)) {
                return;
            }

            switch (priority) {
                case 0:
                    this.requests.add(indexId + "," + archiveId);
                    break;
                case 1:
                    worker.submit(new Runnable() {
                        public void run() {
                            GrabPacketsDecoder.this.session.getGrabPackets().sendCacheArchive(indexId, archiveId, true);
                        }
                    });
                    break;
                case 2:
                case 3:
                    this.requests.clear();
                    break;
                default:
                    System.out.println("[priority=" + priority + "]");
            }

            while(this.requests.size() > 0) {
                String[] request = ((String)this.requests.removeFirst()).split(",");
                this.session.getGrabPackets().sendCacheArchive(Integer.parseInt(request[0]), Integer.parseInt(request[1]), false);
            }

        }
    }
}
