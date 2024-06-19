//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.api.database;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConnectionPool<T extends DatabaseConnection> {
    private DatabaseConfiguration configuration;
    private int maxConnections;
    private int currentConnections;
    private Queue<DatabaseConnection> pool;

    public ConnectionPool(DatabaseConfiguration configuration) {
        this(configuration, 10);
    }

    public ConnectionPool(DatabaseConfiguration configuration, int maxConnections) {
        this.currentConnections = 0;
        this.pool = new ConcurrentLinkedQueue();
        this.configuration = configuration;
        this.maxConnections = maxConnections;
        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            public void run() {
                Iterator<DatabaseConnection> it$ = ConnectionPool.this.pool.iterator();

                while(it$.hasNext()) {
                    DatabaseConnection connection = (DatabaseConnection)it$.next();

                    try {
                        connection.getConnection().createStatement().execute("/* ping */ SELECT 1");
                    } catch (SQLException var4) {
                        it$.remove();
                    }
                }

            }
        }, 0L, 30000L, TimeUnit.MILLISECONDS);
    }

    public DatabaseConnection nextFree() {
        DatabaseConnection connection = (DatabaseConnection)this.pool.poll();
        if (connection != null) {
            if (!connection.isFresh()) {
                --this.currentConnections;
                return this.nextFree();
            } else {
                return connection;
            }
        } else if (this.currentConnections >= this.maxConnections) {
            return null;
        } else {
            connection = this.configuration.newConnection();
            connection.setPool(this);
            if (!connection.connect()) {
                throw new RuntimeException("Connection was unable to connect!");
            } else {
                ++this.currentConnections;
                return connection;
            }
        }
    }

    public void returnConnection(DatabaseConnection connection) {
        this.pool.offer(connection);
    }
}
