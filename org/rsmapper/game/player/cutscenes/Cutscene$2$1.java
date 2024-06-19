//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player.cutscenes;

import org.rsmapper.engine.CoresManager;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.tasks.WorldTask;

class Cutscene$2$1 extends WorldTask {
    Cutscene$2$1(Cutscene.2 var1, Player var2, int[] var3) {
        this.this$1 = var1;
        this.val$player = var2;
        this.val$oldData = var3;
    }

    public void run() {
        CoresManager.slowExecutor.execute(new Cutscene$2$1$1(this, this.val$player, this.val$oldData));
    }
}
