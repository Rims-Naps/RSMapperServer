//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game;

import java.util.Iterator;
import java.util.TimerTask;
import org.rsmapper.game.player.Player;
import org.rsmapper.utilities.misc.Utils;

class World$5 extends TimerTask {
    World$5() {
    }

    public void run() {
        try {
            Iterator var2 = World.getPlayers().iterator();

            while(true) {
                Player player;
                do {
                    do {
                        if (!var2.hasNext()) {
                            return;
                        }

                        player = (Player)var2.next();
                    } while(player == null);
                } while(!player.isRunning());

                int ammountTimes = 1;
                if (player.isResting()) {
                    ++ammountTimes;
                }

                boolean berserker = false;

                for(int skill = 0; skill < 25; ++skill) {
                    if (skill != 23) {
                        for(int time = 0; time < ammountTimes; ++time) {
                            int currentLevel = player.getSkills().getLevel(skill);
                            int normalLevel = player.getSkills().getLevelForXp(skill);
                            if (currentLevel <= normalLevel) {
                                if (currentLevel >= normalLevel) {
                                    break;
                                }

                                player.getSkills().set(skill, currentLevel + 1);
                            } else if (skill != 0 && skill != 2 && skill != 1 && skill != 4 && skill != 6 || !berserker || Utils.getRandom(100) > 15) {
                                player.getSkills().set(skill, currentLevel - 1);
                            }
                        }
                    }
                }
            }
        } catch (Throwable var9) {
            Throwable e = var9;
            e.printStackTrace();
        }
    }
}
