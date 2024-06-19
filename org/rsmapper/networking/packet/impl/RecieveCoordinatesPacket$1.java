//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.networking.packet.impl;

import org.rsmapper.game.ForceMovement;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.tasks.WorldTask;

class RecieveCoordinatesPacket$1 extends WorldTask {
    int ticks;

    RecieveCoordinatesPacket$1(RecieveCoordinatesPacket var1, Player var2, WorldTile var3, WorldTile var4) {
        this.this$0 = var1;
        this.val$player = var2;
        this.val$startTile = var3;
        this.val$destTile = var4;
    }

    public void run() {
        switch (this.ticks) {
            case 0:
                this.val$player.setNextForceMovement(new ForceMovement(this.val$startTile, 0, this.val$destTile, 1, 0));
                break;
            case 1:
                this.val$player.getAttributes().put("moving", false);
                this.stop();
        }

        ++this.ticks;
    }
}
