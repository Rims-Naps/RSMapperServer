//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player.cutscenes;

import org.rsmapper.Constants;
import org.rsmapper.game.RegionBuilder;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.tasks.WorldTasksManager;

class Cutscene$2 implements Runnable {
    Cutscene$2(Cutscene var1, int var2, int var3, int var4, int var5, Player var6) {
        this.this$0 = var1;
        this.val$widthChunks = var2;
        this.val$heightChunks = var3;
        this.val$baseChunkX = var4;
        this.val$baseChunkY = var5;
        this.val$player = var6;
    }

    public void run() {
        try {
            int[] oldData = Cutscene.access$0(this.this$0);
            int[] mapBaseChunks = RegionBuilder.findEmptyChunkBound(this.val$widthChunks, this.val$heightChunks);
            RegionBuilder.copyAllPlanesMap(this.val$baseChunkX, this.val$baseChunkY, mapBaseChunks[0], mapBaseChunks[1], this.val$widthChunks, this.val$heightChunks);
            Cutscene.access$1(this.this$0, new int[]{mapBaseChunks[0], mapBaseChunks[1], this.val$widthChunks, this.val$heightChunks});
            this.val$player.setNextWorldTile(new WorldTile(this.this$0.getBaseX() + this.val$widthChunks * 4, this.this$0.getBaseY() + this.val$heightChunks * 4, 0));
            Cutscene.access$2(this.this$0, false);
            if (Constants.DEBUG) {
                System.out.println("Bases: " + this.this$0.getBaseX() + ", " + this.this$0.getBaseY());
            }

            WorldTasksManager.schedule(new Cutscene$2$1(this, this.val$player, oldData), 1);
        } catch (Throwable var3) {
            Throwable e = var3;
            e.printStackTrace();
        }

    }
}
