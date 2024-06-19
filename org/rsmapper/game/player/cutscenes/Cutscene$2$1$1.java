//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player.cutscenes;

import org.rsmapper.game.RegionBuilder;
import org.rsmapper.game.player.Player;

class Cutscene$2$1$1 implements Runnable {
    Cutscene$2$1$1(Cutscene.2.1 var1, Player var2, int[] var3) {
        this.this$2 = var1;
        this.val$player = var2;
        this.val$oldData = var3;
    }

    public void run() {
        this.val$player.getPackets().sendWindowsPane(this.val$player.getInterfaceManager().hasResizableScreen() ? 746 : 548, 0);
        if (this.val$oldData != null) {
            RegionBuilder.destroyMap(this.val$oldData[0], this.val$oldData[1], this.val$oldData[1], this.val$oldData[2]);
        }

    }
}
