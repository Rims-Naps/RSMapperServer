//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player.content;

import org.rsmapper.game.Animation;
import org.rsmapper.game.World;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.tasks.WorldTask;

class Magic$4 extends WorldTask {
    boolean teled;

    Magic$4(Player var1, WorldTile var2) {
        this.val$player = var1;
        this.val$tile = var2;
    }

    public void run() {
        if (!this.teled) {
            this.val$player.setNextAnimation(new Animation(4731));
            this.teled = true;
        } else {
            WorldTile teleTile = this.val$tile;

            for(int trycount = 0; trycount < 10; ++trycount) {
                teleTile = new WorldTile(this.val$tile, 2);
                if (World.canMoveNPC(this.val$tile.getPlane(), teleTile.getX(), teleTile.getY(), this.val$player.getSize())) {
                    break;
                }

                teleTile = this.val$tile;
            }

            this.val$player.setNextWorldTile(teleTile);
            this.val$player.getControllerManager().magicTeleported(1);
            if (this.val$player.getControllerManager().getController() == null) {
                Magic.teleControlersCheck(this.val$player, teleTile);
            }

            this.val$player.setNextFaceWorldTile(new WorldTile(teleTile.getX(), teleTile.getY() - 1, teleTile.getPlane()));
            this.val$player.setDirection(6);
            this.val$player.setNextAnimation(new Animation(-1));
            this.val$player.unlock();
            this.stop();
        }

    }
}
