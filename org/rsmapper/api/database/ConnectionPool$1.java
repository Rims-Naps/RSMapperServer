//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.api.database;

import java.sql.SQLException;
import java.util.Iterator;

class ConnectionPool$1 implements Runnable {
    ConnectionPool$1(ConnectionPool var1) {
        this.this$0 = var1;
    }

    public void run() {
        Iterator<DatabaseConnection> it$ = ConnectionPool.access$0(this.this$0).iterator();

        while(it$.hasNext()) {
            DatabaseConnection connection = (DatabaseConnection)it$.next();

            try {
                connection.getConnection().createStatement().execute("/* ping */ SELECT 1");
            } catch (SQLException var4) {
                it$.remove();
            }
        }

    }
}
