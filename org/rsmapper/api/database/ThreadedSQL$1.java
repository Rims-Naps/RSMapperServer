//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.api.database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.rsmapper.api.database.callback.ThreadedSQLCallback;

class ThreadedSQL$1 implements Runnable {
    ThreadedSQL$1(ThreadedSQL var1, PreparedStatement var2, ThreadedSQLCallback var3) {
        this.this$0 = var1;
        this.val$statement = var2;
        this.val$callback = var3;
    }

    public void run() {
        try {
            ThreadedSQL.access$0(this.this$0, this.val$statement, this.val$callback);
        } catch (SQLException var2) {
            SQLException e = var2;
            this.val$callback.queryError(e);
        }

    }
}
