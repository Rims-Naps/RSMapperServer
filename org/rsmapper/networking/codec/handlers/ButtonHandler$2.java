//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.networking.codec.handlers;

import org.rsmapper.api.input.IntegerInputAction;
import org.rsmapper.game.player.Player;

class ButtonHandler$2 extends IntegerInputAction {
    ButtonHandler$2(Player var1, int var2) {
        this.val$player = var1;
        this.val$slotId = var2;
    }

    public void handle(int input) {
        this.val$player.getBank().withdrawItem(this.val$slotId, input);
        this.val$player.getBank().setLastX(input);
        this.val$player.getBank().refreshLastX();
    }
}
