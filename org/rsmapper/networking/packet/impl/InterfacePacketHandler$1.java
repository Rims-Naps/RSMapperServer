//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.networking.packet.impl;

import org.rsmapper.game.item.Item;
import org.rsmapper.game.player.Player;

class InterfacePacketHandler$1 implements Runnable {
    InterfacePacketHandler$1(InterfacePacketHandler var1, Player var2, Player var3, Item var4) {
        this.this$0 = var1;
        this.val$player = var2;
        this.val$p2 = var3;
        this.val$item = var4;
    }

    public void run() {
        if (this.val$player.getControllerManager().processItemOnPlayer(this.val$p2, this.val$item)) {
            ;
        }
    }
}
