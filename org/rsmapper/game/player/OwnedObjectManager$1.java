//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player;

import org.rsmapper.game.tasks.WorldTask;

class OwnedObjectManager$1 extends WorldTask {
    OwnedObjectManager$1(OwnedObjectManager var1) {
        this.val$manager = var1;
    }

    public void run() {
        this.val$manager.delete();
    }
}
