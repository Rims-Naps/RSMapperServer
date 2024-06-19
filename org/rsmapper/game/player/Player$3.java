//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player;

import org.rsmapper.game.Animation;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.tasks.WorldTask;

class Player$3 extends WorldTask {
    Player$3(Player var1, boolean var2, WorldTile var3, String var4) {
        this.this$0 = var1;
        this.val$resetAnimation = var2;
        this.val$dest = var3;
        this.val$message = var4;
    }

    public void run() {
        if (!this.this$0.isDead()) {
            if (this.val$resetAnimation) {
                this.this$0.setNextAnimation(new Animation(-1));
            }

            this.this$0.setNextWorldTile(this.val$dest);
            if (this.val$message != null) {
                this.this$0.getPackets().sendGameMessage(this.val$message);
            }

        }
    }
}
