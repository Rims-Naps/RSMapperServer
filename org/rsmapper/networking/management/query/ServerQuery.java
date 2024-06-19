//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.networking.management.query;

public abstract class ServerQuery {
    private String query;

    public ServerQuery() {
    }

    public abstract String[] getQueryListeners();

    public abstract String getDescription();

    public abstract String onRequest();

    public String getQuery() {
        return this.query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
