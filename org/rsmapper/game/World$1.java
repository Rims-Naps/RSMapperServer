//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game;

import org.rsmapper.game.player.OwnedObjectManager;

class World$1 implements Runnable {
    World$1() {
    }

    public void run() {
        try {
            OwnedObjectManager.processAll();
        } catch (Throwable var2) {
            Throwable e = var2;
            e.printStackTrace();
        }

    }
}
