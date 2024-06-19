//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player;

class Player$1 implements Runnable {
    Player$1(Player var1, int var2) {
        this.this$0 = var1;
        this.val$tryCount = var2;
    }

    public void run() {
        try {
            Player.access$0(this.this$0, false);
            this.this$0.finish(this.val$tryCount + 1);
        } catch (Throwable var2) {
            Throwable e = var2;
            e.printStackTrace();
        }

    }
}
