//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game;

import org.rsmapper.game.Region.ForceClipping;

class Region$1 implements Runnable {
    Region$1(Region var1) {
        this.this$0 = var1;
    }

    public void run() {
        try {
            this.this$0.loadRegionMap();
            Region.ForceClipping[] var4;
            int var3 = (var4 = ForceClipping.values()).length;

            for(int var2 = 0; var2 < var3; ++var2) {
                Region.ForceClipping regions = var4[var2];
                if (this.this$0.regionId == ForceClipping.access$2(regions)) {
                    WorldTile[] var8;
                    int var7 = (var8 = ForceClipping.access$3(regions)).length;

                    for(int var6 = 0; var6 < var7; ++var6) {
                        WorldTile tile = var8[var6];
                        this.this$0.clip(tile.getPlane(), tile.getX(), tile.getY());
                    }
                }
            }

            this.this$0.setLoadMapStage(2);
        } catch (Throwable var9) {
            Throwable e = var9;
            e.printStackTrace();
        }

    }
}
