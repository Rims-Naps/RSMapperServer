//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.networking.protocol.js5;

class GrabPacketsDecoder$1 implements Runnable {
    GrabPacketsDecoder$1(GrabPacketsDecoder var1, int var2, int var3) {
        this.this$0 = var1;
        this.val$indexId = var2;
        this.val$archiveId = var3;
    }

    public void run() {
        GrabPacketsDecoder.access$0(this.this$0).getGrabPackets().sendCacheArchive(this.val$indexId, this.val$archiveId, true);
    }
}
