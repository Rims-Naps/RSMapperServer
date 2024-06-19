//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player;

import org.rsmapper.game.tasks.WorldTask;

class Player$4 extends WorldTask {
    int count;

    Player$4(Player var1, boolean var2) {
        this.this$0 = var1;
        this.val$enhanced = var2;
        this.count = 5;
    }

    public void run() {
        if (!this.this$0.isDead() && !this.this$0.hasFinished() && this.this$0.getHitpoints() < this.this$0.getMaxHitpoints()) {
            this.this$0.heal(this.val$enhanced ? 80 : 40);
            if (this.count-- == 0) {
                this.stop();
            }
        } else {
            this.stop();
        }
    }
}
