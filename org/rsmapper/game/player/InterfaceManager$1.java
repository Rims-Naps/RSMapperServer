//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player;

class InterfaceManager$1 implements Runnable {
    InterfaceManager$1(InterfaceManager var1) {
        this.this$0 = var1;
    }

    public void run() {
        if (this.this$0.hasResizableScreen()) {
            InterfaceManager.access$0(this.this$0).getPackets().closeInterface(80);
            InterfaceManager.access$0(this.this$0).getPackets().closeInterface(81);
        } else {
            InterfaceManager.access$0(this.this$0).getPackets().closeInterface(19);
            InterfaceManager.access$0(this.this$0).getPackets().closeInterface(20);
        }

    }
}
