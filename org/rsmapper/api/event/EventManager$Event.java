//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.api.event;

public class EventManager$Event {
    private final int id;
    private final EventListener.EventType type;

    public EventManager$Event(int id, EventListener.EventType type) {
        this.id = id;
        this.type = type;
    }

    public boolean equals(Object object) {
        if (object instanceof EventManager$Event) {
            EventManager$Event o = (EventManager$Event)object;
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
