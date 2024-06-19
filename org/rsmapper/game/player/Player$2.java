//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player;

import org.rsmapper.game.tasks.WorldTask;

class Player$2 extends WorldTask {
    Player$2(Player var1) {
        this.this$0 = var1;
    }

    public void run() {
        this.this$0.getPackets().closeInterface(this.this$0.getInterfaceManager().hasResizableScreen() ? 10 : 8);
    }
}
