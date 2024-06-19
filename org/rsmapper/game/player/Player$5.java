//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player;

import org.rsmapper.game.Entity;
import org.rsmapper.game.Graphics;
import org.rsmapper.game.Hit;
import org.rsmapper.game.World;
import org.rsmapper.game.tasks.WorldTask;

class Player$5 extends WorldTask {
    Player$5(Player var1, Hit var2, Player var3, Entity var4) {
        this.this$0 = var1;
        this.val$hit = var2;
        this.val$target = var3;
        this.val$user = var4;
    }

    public void run() {
        this.this$0.setNextGraphics(new Graphics(2264));
        if (this.val$hit.getDamage() > 0) {
            World.sendProjectile(this.val$target, this.val$user, 2263, 11, 11, 20, 5, 0, 0);
        }

    }
}
