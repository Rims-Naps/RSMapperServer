//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.api.event.listeners.objects;

import org.rsmapper.api.event.EventListener;
import org.rsmapper.game.WorldObject;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.item.Item;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;

public class TeleportPortalListener extends EventListener {
    public TeleportPortalListener() {
    }

    public int[] getEventIds() {
        return new int[]{42219};
    }

    public boolean handleButtonClick(Player player, int interfaceId, int buttonId, int packetId, int slotId, int itemId) {
        return false;
    }

    public boolean handleObjectClick(Player player, int objectId, WorldObject worldObject, WorldTile tile, EventListener.ClickOption option) {
        return true;
    }

    public boolean handleNPCClick(Player player, NPC npc, EventListener.ClickOption option) {
        return false;
    }

    public boolean handleItemClick(Player player, Item item, EventListener.ClickOption option) {
        return false;
    }
}
