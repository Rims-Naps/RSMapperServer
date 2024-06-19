//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game;

class World$8 implements Runnable {
    World$8(WorldObject var1) {
        this.val$object = var1;
    }

    public void run() {
        try {
            if (!World.isSpawnedObject(this.val$object)) {
                return;
            }

            World.removeObject(this.val$object);
        } catch (Throwable var2) {
            Throwable e = var2;
            e.printStackTrace();
        }

    }
}
