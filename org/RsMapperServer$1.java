//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class RsMapperServer$1 extends WindowAdapter {
    RsMapperServer$1(RsMapperServer var1) {
        this.this$0 = var1;
    }

    public void windowClosing(WindowEvent we) {
        RsMapperServer.shutdown();
        System.exit(-1);
    }
}
