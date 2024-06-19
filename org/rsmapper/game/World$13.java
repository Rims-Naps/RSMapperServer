//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game;

import org.rsmapper.game.item.FloorItem;

class World$13 implements Runnable {
    World$13(FloorItem var1) {
        this.val$floorItem = var1;
    }

    public void run() {
        try {
            int regionId = this.val$floorItem.getTile().getRegionId();
            Region region = World.getRegion(regionId);
            if (!region.forceGetFloorItems().contains(this.val$floorItem)) {
                return;
            }

            region.forceGetFloorItems().remove(this.val$floorItem);
            World.players().filter((p) -> {
                return p.getPlane() == var0.getTile().getPlane() && p.getMapRegionsIds().contains(regionId);
            }).forEach((p) -> {
                p.getPackets().sendRemoveGroundItem(var0);
            });
        } catch (Throwable var3) {
            Throwable e = var3;
            e.printStackTrace();
        }

    }
}
