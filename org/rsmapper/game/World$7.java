//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.RsMapperServer;
import org.rsmapper.game.player.Player;

class World$7 implements Runnable {
    int seconds;

    World$7(int var1, boolean var2, long var3) {
        this.val$delay = var1;
        this.val$restart = var2;
        this.val$updateTime = var3;
        this.seconds = 0;
    }

    public void run() {
        Iterator var2;
        Player player;
        if (this.seconds++ == this.val$delay) {
            try {
                var2 = World.getPlayers().iterator();

                while(var2.hasNext()) {
                    player = (Player)var2.next();
                    if (player != null && player.hasStarted()) {
                        player.realFinish();
                    }
                }

                if (this.val$restart) {
                    RsMapperServer.restart();
                } else {
                    RsMapperServer.shutdown();
                    System.exit(-1);
                }
            } catch (Throwable var5) {
                Throwable e = var5;
                e.printStackTrace();
            }
        } else {
            var2 = World.getPlayers().iterator();

            while(var2.hasNext()) {
                player = (Player)var2.next();
                if (player != null && player.hasStarted() && !player.hasFinished()) {
                    long updates = TimeUnit.MILLISECONDS.toSeconds(this.val$updateTime - System.currentTimeMillis());
                    player.sendNotification((World.access$3() ? "Server Restart" : "Update") + " In: " + updates, -1);
                    World.updateIn = updates;
                }
            }
        }

    }
}
