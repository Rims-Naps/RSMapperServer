//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.engine.process;

class ProcessManagement$1 implements Runnable {
    ProcessManagement$1(ProcessManagement var1, TimedProcess var2) {
        this.this$0 = var1;
        this.val$process = var2;
    }

    public void run() {
        try {
            this.val$process.execute();
        } catch (Exception var2) {
            Exception e = var2;
            e.printStackTrace();
        }

    }
}
