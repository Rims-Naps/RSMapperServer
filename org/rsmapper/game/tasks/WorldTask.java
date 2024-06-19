//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.tasks;

public abstract class WorldTask implements Runnable {
    protected boolean needRemove;

    public WorldTask() {
    }

    public final void stop() {
        this.needRemove = true;
    }
}
