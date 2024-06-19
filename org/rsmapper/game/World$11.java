//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game;

import org.rsmapper.game.item.FloorItem;

class World$11 implements Runnable {
    World$11(FloorItem var1, int var2) {
        this.val$floorItem = var1;
        this.val$publicTime = var2;
    }

    public void run() {
        try {
            World.turnPublic(this.val$floorItem, this.val$publicTime);
        } catch (Throwable var2) {
            Throwable e = var2;
            e.printStackTrace();
        }

    }
}
