//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player.content;

import org.rsmapper.game.Animation;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.tasks.WorldTask;

class Magic$3 extends WorldTask {
    boolean teled;

    Magic$3(Player var1) {
        this.val$player = var1;
    }

    public void run() {
        if (!this.teled) {
            this.val$player.setNextAnimation(new Animation(4731));
            this.teled = true;
        } else {
            this.val$player.getControllerManager().magicTeleported(1);
            this.val$player.setDirection(6);
            this.val$player.setNextAnimation(new Animation(-1));
            this.val$player.unlock();
            this.stop();
        }

    }
}
