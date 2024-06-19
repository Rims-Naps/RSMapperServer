//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.networking.management.query;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.rsmapper.utilities.misc.FileClassLoader;

public class ServerQueryHandler {
    private static final Map<String, ServerQuery> SERVER_QUERIES = new HashMap();

    public ServerQueryHandler() {
    }

    public static void load() {
        Iterator var1 = FileClassLoader.getClassesInDirectory(ServerQueryHandler.class.getPackage().getName() + ".impl").iterator();

        while(var1.hasNext()) {
            Object clazz = var1.next();

            try {
                ServerQuery skeleton = (ServerQuery)clazz;
                if (skeleton.getQueryListeners() == null) {
                    throw new IllegalStateException("Could not register " + skeleton.getClass().getCanonicalName() + "; no parameters");
                }

                String[] var6;
                int var5 = (var6 = skeleton.getQueryListeners()).length;

                for(int var4 = 0; var4 < var5; ++var4) {
                    String parameter = var6[var4];
                    getServerQueries().put(parameter.toLowerCase(), skeleton);
                }
            } catch (Throwable var7) {
                Throwable t = var7;
                t.printStackTrace();
            }
        }

    }

    public static String handleQuery(String query) {
        String[] split = query.split(" ");
        ServerQuery serverQuery = (ServerQuery)getServerQueries().get(split[0].toLowerCase());
        if (serverQuery == null) {
            return "No such query " + query + "...";
        } else {
            serverQuery.setQuery(query);
            return serverQuery.onRequest();
        }
    }

    public static Map<String, ServerQuery> getServerQueries() {
        return SERVER_QUERIES;
    }
}
