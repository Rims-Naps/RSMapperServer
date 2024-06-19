//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.api.event.listeners.interfaces;

import org.rsmapper.api.event.EventListener;
import org.rsmapper.game.WorldObject;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.item.Item;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;

public class GameframeHandler extends EventListener {
    public GameframeHandler() {
    }

    public int[] getEventIds() {
        return new int[]{548, 746};
    }

    public boolean handleButtonClick(Player player, int interfaceId, int buttonId, int packetId, int slotId, int itemId) {
        System.out.println("ButtonID: " + buttonId + " InterfaceID: " + interfaceId);
        if ((buttonId != 132 || interfaceId != 548) && (buttonId != 42 || interfaceId != 746)) {
            if (buttonId == 130 && interfaceId == 548 || buttonId == 40 && interfaceId == 746) {
                player.getInterfaceManager().sendTaskTab(false);
                return true;
            } else if (buttonId == 130 && interfaceId == 548 || buttonId == 40 && interfaceId == 746) {
                player.getInterfaceManager().sendTaskTab(false);
                return true;
            } else if ((buttonId != 103 || interfaceId != 548) && (buttonId != 51 || interfaceId != 746)) {
                return buttonId == 184 && interfaceId == 548 || buttonId == 175 && interfaceId == 746;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public boolean handleObjectClick(Player player, int objectId, WorldObject worldObject, WorldTile tile, EventListener.ClickOption option) {
        return false;
    }

    public boolean handleNPCClick(Player player, NPC npc, EventListener.ClickOption option) {
        return false;
    }

    public boolean handleItemClick(Player player, Item item, EventListener.ClickOption option) {
        return false;
    }
}
