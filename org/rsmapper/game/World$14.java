//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game;

import org.rsmapper.game.item.FloorItem;

class World$14 implements Runnable {
    World$14(FloorItem var1) {
        this.val$floorItem = var1;
    }

    public void run() {
        try {
            World.addGroundItemForever(this.val$floorItem, this.val$floorItem.getTile());
        } catch (Throwable var2) {
            Throwable e = var2;
            e.printStackTrace();
        }

    }
}
