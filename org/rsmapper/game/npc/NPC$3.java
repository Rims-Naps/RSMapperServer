//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.npc;

import org.rsmapper.game.Entity;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.tasks.WorldTask;

class NPC$3 extends WorldTask {
    int loop;

    NPC$3(NPC var1, Entity var2) {
        this.this$0 = var1;
        this.val$source = var2;
    }

    public void run() {
        if (this.loop >= 5) {
            if (this.val$source instanceof Player) {
                ((Player)this.val$source).getControllerManager().processNPCDeath(this.this$0.getId());
            }

            this.this$0.drop();
            this.this$0.reset();
            this.this$0.setLocation(NPC.access$0(this.this$0));
            this.this$0.finish();
            if (!this.this$0.isSpawned()) {
                this.this$0.setRespawnTask();
            }

            this.stop();
        }

        ++this.loop;
    }
}
