//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.api.event;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.rsmapper.api.event.EventListener.EventType;
import org.rsmapper.game.WorldObject;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.item.Item;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;

public class EventManager {
    private static final EventManager MANAGER = new EventManager();
    private static final Map<Event, EventListener> EVENTS_MAP = new HashMap();

    public EventManager() {
    }

    public void load() {
        EVENTS_MAP.clear();
    }

    public boolean handleButtonClick(Player player, int interfaceId, int buttonId, int packetId, int slotId, int slotId2) {
        EventListener eventListener = this.getEventListener(EventType.INTERFACE, interfaceId);
        return eventListener != null && eventListener.handleButtonClick(player, interfaceId, buttonId, packetId, slotId, slotId2);
    }

    public boolean handleObjectClick(Player player, int objectId, WorldObject worldObject, WorldTile tile, EventListener.ClickOption option) {
        EventListener eventListener = this.getEventListener(EventType.OBJECT, objectId);
        return eventListener != null && eventListener.handleObjectClick(player, objectId, worldObject, tile, option);
    }

    public boolean handleNPCClick(Player player, NPC npc, EventListener.ClickOption option) {
        EventListener eventListener = this.getEventListener(EventType.NPC, npc.getId());
        return eventListener != null && eventListener.handleNPCClick(player, npc, option);
    }

    public boolean handleItemClick(Player player, Item item, EventListener.ClickOption option) {
        EventListener eventListener = this.getEventListener(EventType.ITEM, item.getId());
        return eventListener != null && eventListener.handleItemClick(player, item, option);
    }

    public void register(Event event, EventListener listener) {
        EVENTS_MAP.entrySet().stream().filter((e) -> {
            return ((Event)e.getKey()).equals(event);
        }).forEach((e) -> {
            int[] var6;
            int var5 = (var6 = ((EventListener)e.getValue()).getEventIds()).length;

            for(int var4 = 0; var4 < var5; ++var4) {
                int bind = var6[var4];
                int[] var10;
                int var9 = (var10 = listener.getEventIds()).length;

                for(int var8 = 0; var8 < var9; ++var8) {
                    int listenerBind = var10[var8];
                    if (listenerBind == bind) {
                        throw new IllegalStateException("There is already an event registered![" + event + "]");
                    }
                }
            }

        });
        EVENTS_MAP.put(event, listener);
    }

    public static EventManager get() {
        return MANAGER;
    }

    public EventListener getEventListener(EventListener.EventType type, int id) {
        Event e = new Event(id, type);
        Iterator<Map.Entry<Event, EventListener>> it = EVENTS_MAP.entrySet().iterator();

        while(it.hasNext()) {
            Map.Entry<Event, EventListener> entry = (Map.Entry)it.next();
            if (((Event)entry.getKey()).equals(e)) {
                return (EventListener)entry.getValue();
            }
        }

        return null;
    }

    public static class Event {
        private final int id;
        private final EventListener.EventType type;

        public Event(int id, EventListener.EventType type) {
            this.id = id;
            this.type = type;
        }

        public boolean equals(Object object) {
            if (object instanceof Event) {
                Event o = (Event)object;
                if (o.getId() == this.getId() && o.getType() == this.getType()) {
                    return true;
                }
            }

            return false;
        }

        public EventListener.EventType getType() {
            return this.type;
        }

        public int getId() {
            return this.id;
        }
    }
}
