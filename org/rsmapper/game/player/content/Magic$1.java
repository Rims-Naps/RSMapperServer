//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player.content;

import org.rsmapper.game.WorldTile;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.tasks.WorldTask;

class Magic$1 extends WorldTask {
    Magic$1(Player var1, WorldTile var2) {
        this.val$player = var1;
        this.val$tile = var2;
    }

    public void run() {
        this.val$player.unlock();
        Magic.sendObjectTeleportSpell(this.val$player, false, this.val$tile);
    }
}
