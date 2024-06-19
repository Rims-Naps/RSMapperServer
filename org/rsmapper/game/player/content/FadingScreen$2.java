//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player.content;

import org.rsmapper.engine.CoresManager;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.tasks.WorldTask;

class FadingScreen$2 extends WorldTask {
    FadingScreen$2(Player var1) {
        this.val$player = var1;
    }

    public void run() {
        this.val$player.getInterfaceManager().setFadingInterface(170);
        CoresManager.fastExecutor.schedule(new FadingScreen$2$1(this, this.val$player), 2000L);
    }
}
