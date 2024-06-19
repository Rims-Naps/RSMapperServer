//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player.cutscenes;

import org.rsmapper.game.RegionBuilder;

class Cutscene$1 implements Runnable {
    Cutscene$1(Cutscene var1) {
        this.this$0 = var1;
    }

    public void run() {
        try {
            if (Cutscene.access$0(this.this$0) != null) {
                RegionBuilder.destroyMap(Cutscene.access$0(this.this$0)[0], Cutscene.access$0(this.this$0)[1], Cutscene.access$0(this.this$0)[1], Cutscene.access$0(this.this$0)[2]);
            }
        } catch (Throwable var2) {
            Throwable e = var2;
            e.printStackTrace();
        }

    }
}
