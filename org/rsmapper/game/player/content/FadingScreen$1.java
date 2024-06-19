//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player.content;

import java.util.TimerTask;
import org.rsmapper.game.player.Player;

class FadingScreen$1 extends TimerTask {
    FadingScreen$1(Player var1, Runnable var2) {
        this.val$player = var1;
        this.val$event = var2;
    }

    public void run() {
        try {
            FadingScreen.unfade(this.val$player, this.val$event);
        } catch (Throwable var2) {
            Throwable e = var2;
            e.printStackTrace();
        }

    }
}
