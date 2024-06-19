//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player;

class Bank$1 implements Runnable {
    Bank$1(Bank var1, int var2) {
        this.this$0 = var1;
        this.val$lastGameTab = var2;
    }

    public void run() {
        Bank.access$0(this.this$0).getInterfaceManager().sendInventory();
        Bank.access$0(this.this$0).getInventory().unlockInventoryOptions();
        Bank.access$0(this.this$0).getInterfaceManager().sendEquipment();
        Bank.access$0(this.this$0).getInterfaceManager().openGameTab(this.val$lastGameTab);
    }
}
