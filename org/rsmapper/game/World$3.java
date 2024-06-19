//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game;

import java.util.Iterator;
import java.util.TimerTask;
import org.rsmapper.game.player.Player;

class World$3 extends TimerTask {
    World$3() {
    }

    public void run() {
        try {
            Iterator var2 = World.getPlayers().iterator();

            while(true) {
                Player player;
                do {
                    do {
                        do {
                            do {
                                if (!var2.hasNext()) {
                                    World.access$1(!World.access$0());
                                    return;
                                }

                                player = (Player)var2.next();
                            } while(player == null);
                        } while(player.isDead());
                    } while(!player.isRunning());
                } while(World.access$0() && player.getSkills().getLevel(16) < 70);

                player.restoreRunEnergy();
            }
        } catch (Throwable var3) {
            Throwable e = var3;
            e.printStackTrace();
        }
    }
}
