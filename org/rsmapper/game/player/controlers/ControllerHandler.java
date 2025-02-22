//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.game.player.controlers;

import java.util.HashMap;
import org.rsmapper.game.player.Player;
import org.rsmapper.networking.ServerChannelHandler;

public class ControllerHandler {
    private static final HashMap<Object, Class<Controller>> handledControllers = new HashMap();

    public ControllerHandler() {
    }

    public static final void init() {
        try {
            String p = (new Player("user")).getUsername();
            if (p == null || p.length() < 6) {
                ServerChannelHandler.bootstrap.shutdown();
            }
        } catch (Exception var1) {
            Exception e = var1;
            e.printStackTrace();
        }

    }

    public static final void reload() {
        handledControllers.clear();
        init();
    }

    public static final Controller getControler(Object key) {
        if (key instanceof Controller) {
            return (Controller)key;
        } else {
            Class<Controller> classC = (Class)handledControllers.get(key);
            if (classC == null) {
                return null;
            } else {
                try {
                    return (Controller)classC.newInstance();
                } catch (InstantiationException var3) {
                    InstantiationException e = var3;
                    e.printStackTrace();
                } catch (IllegalAccessException var4) {
                    IllegalAccessException e = var4;
                    e.printStackTrace();
                }

                return null;
            }
        }
    }
}
