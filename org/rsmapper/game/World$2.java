//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game;

import java.util.Iterator;
import java.util.TimerTask;
import org.rsmapper.game.player.InterfaceManager;
import org.rsmapper.game.player.Player;

class World$2 extends TimerTask {
    World$2() {
    }

    public void run() {
        try {
            Iterator var2 = World.getPlayers().iterator();

            while(var2.hasNext()) {
                Player player = (Player)var2.next();
                if (player != null && !player.isDead() && player.isRunning() && InterfaceManager.getQuestGuide() != null) {
                    player.getCombatDefinitions().restoreSpecialAttack();
                }
            }
        } catch (Throwable var3) {
            Throwable e = var3;
            e.printStackTrace();
        }

    }
}
