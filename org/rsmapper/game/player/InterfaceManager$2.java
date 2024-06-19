//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player;

class InterfaceManager$2 implements Runnable {
    InterfaceManager$2(InterfaceManager var1) {
        this.this$0 = var1;
    }

    public void run() {
        System.out.println("We should remove tbh");
        this.this$0.removeTab(this.this$0.hasResizableScreen() ? 40 : 9);
        this.this$0.removeTab(this.this$0.hasResizableScreen() ? 41 : 11);
    }
}
