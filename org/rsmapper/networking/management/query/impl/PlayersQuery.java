//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.networking.management.query.impl;

import java.util.Iterator;
import org.rsmapper.game.World;
import org.rsmapper.game.player.Player;
import org.rsmapper.networking.management.query.ServerQuery;

public class PlayersQuery extends ServerQuery {
    public PlayersQuery() {
    }

    public String[] getQueryListeners() {
        return new String[]{"listplayers", "players"};
    }

    public String getDescription() {
        return "Shows all players currently online.";
    }

    public String onRequest() {
        String players = new String();

        Player pl;
        for(Iterator var3 = World.getPlayers().iterator(); var3.hasNext(); players = players + pl.getDisplayName() + ", ") {
            pl = (Player)var3.next();
        }

        return players + "\n\t[size=" + World.getPlayers().size() + "]";
    }
}
