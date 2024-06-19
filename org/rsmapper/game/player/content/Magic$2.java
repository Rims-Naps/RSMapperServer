//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player.content;

import org.rsmapper.game.Animation;
import org.rsmapper.game.Graphics;
import org.rsmapper.game.World;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.tasks.WorldTask;

class Magic$2 extends WorldTask {
    Magic$2(WorldTile var1, boolean var2, Player var3, int var4, double var5, int var7, int var8) {
        this.val$tile = var1;
        this.val$randomize = var2;
        this.val$player = var3;
        this.val$teleType = var4;
        this.val$xp = var5;
        this.val$downEmoteId = var7;
        this.val$downGraphicId = var8;
    }

    public void run() {
        WorldTile teleTile = this.val$tile;
        if (this.val$randomize) {
            for(int trycount = 0; trycount < 10; ++trycount) {
                teleTile = new WorldTile(this.val$tile, 2);
                if (World.isTileFree(this.val$tile.getPlane(), teleTile.getX(), teleTile.getY(), this.val$player.getSize())) {
                    break;
                }

                teleTile = this.val$tile;
            }
        }

        this.val$player.setNextWorldTile(teleTile);
        this.val$player.getControllerManager().magicTeleported(this.val$teleType);
        if (this.val$player.getControllerManager().getController() == null) {
            Magic.teleControlersCheck(this.val$player, teleTile);
        }

        if (this.val$xp != 0.0) {
            this.val$player.getSkills().addXp(6, this.val$xp, new boolean[0]);
        }

        if (this.val$downEmoteId != -1) {
            this.val$player.setNextAnimation(new Animation(this.val$downEmoteId == -2 ? -1 : this.val$downEmoteId));
        }

        if (this.val$downGraphicId != -1) {
            this.val$player.setNextGraphics(new Graphics(this.val$downGraphicId));
        }

        if (this.val$teleType == 0) {
            this.val$player.getPackets().sendSound(5524, 0, 2);
            this.val$player.setNextFaceWorldTile(new WorldTile(teleTile.getX(), teleTile.getY() - 1, teleTile.getPlane()));
            this.val$player.setDirection(6);
        }

        if (this.val$player.getTeleportationEvent() != null) {
            this.val$player.getTeleportationEvent().run();
            this.val$player.setTeleportationEvent((Runnable)null);
        }

        this.val$player.stopAll();
    }
}
