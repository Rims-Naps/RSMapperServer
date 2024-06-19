//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player.content;

import java.util.TimerTask;
import org.rsmapper.game.player.Player;

class FadingScreen$2$1 extends TimerTask {
    FadingScreen$2$1(FadingScreen.2 var1, Player var2) {
        this.this$1 = var1;
        this.val$player = var2;
    }

    public void run() {
        try {
            this.val$player.getInterfaceManager().closeFadingInterface();
        } catch (Throwable var2) {
            Throwable e = var2;
            e.printStackTrace();
        }

    }
}
