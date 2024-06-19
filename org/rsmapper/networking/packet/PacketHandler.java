//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.networking.packet;

import org.rsmapper.game.player.Player;
import org.rsmapper.networking.codec.stream.InputStream;

public abstract class PacketHandler {
    public PacketHandler() {
    }

    public abstract void handle(Player var1, Integer var2, Integer var3, InputStream var4);
}
