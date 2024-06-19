//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game;

import org.rsmapper.game.item.Item;
import org.rsmapper.game.player.Player;

class World$6 implements Runnable {
    World$6(WorldObject var1, int var2) {
        this.val$object = var1;
        this.val$replaceId = var2;
    }

    public void run() {
        try {
            World.removeObject(this.val$object);
            World.addGroundItem(new Item(this.val$replaceId), this.val$object, (Player)null, false, 180L);
        } catch (Throwable var2) {
            Throwable e = var2;
            e.printStackTrace();
        }

    }
}
