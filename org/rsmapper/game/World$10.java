//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game;

class World$10 implements Runnable {
    World$10(WorldObject var1) {
        this.val$object = var1;
    }

    public void run() {
        try {
            World.spawnObject(this.val$object);
        } catch (Throwable var2) {
            Throwable e = var2;
            e.printStackTrace();
        }

    }
}
