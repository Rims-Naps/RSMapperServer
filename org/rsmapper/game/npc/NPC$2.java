//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.npc;

class NPC$2 implements Runnable {
    NPC$2(NPC var1) {
        this.this$0 = var1;
    }

    public void run() {
        try {
            this.this$0.spawn();
        } catch (Throwable var2) {
            Throwable e = var2;
            e.printStackTrace();
        }

    }
}
