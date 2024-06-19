//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game;

import java.util.Iterator;
import java.util.TimerTask;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;

class World$4 extends TimerTask {
    World$4() {
    }

    public void run() {
        try {
            Iterator var2 = World.getPlayers().iterator();

            while(var2.hasNext()) {
                Player player = (Player)var2.next();
                if (player != null && !player.isDead() && player.isRunning()) {
                    player.restoreHitPoints();
                }
            }

            var2 = World.access$2().iterator();

            while(var2.hasNext()) {
                NPC npc = (NPC)var2.next();
                if (npc != null && !npc.isDead() && !npc.hasFinished()) {
                    npc.restoreHitPoints();
                }
            }
        } catch (Throwable var3) {
            Throwable e = var3;
            e.printStackTrace();
        }

    }
}
