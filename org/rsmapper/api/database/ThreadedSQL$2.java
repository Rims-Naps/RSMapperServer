//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.api.database;

import java.sql.SQLException;
import org.rsmapper.api.database.callback.ThreadedSQLCallback;

class ThreadedSQL$2 implements Runnable {
    ThreadedSQL$2(ThreadedSQL var1, String var2, ThreadedSQLCallback var3) {
        this.this$0 = var1;
        this.val$query = var2;
        this.val$callback = var3;
    }

    public void run() {
        try {
            ThreadedSQL.access$1(this.this$0, this.val$query, this.val$callback);
        } catch (SQLException var2) {
            SQLException e = var2;
            this.val$callback.queryError(e);
        }

    }
}
