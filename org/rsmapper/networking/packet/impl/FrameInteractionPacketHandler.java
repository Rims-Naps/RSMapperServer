//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.networking.packet.impl;

import org.rsmapper.game.player.Player;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.networking.packet.PacketHandler;
import org.rsmapper.networking.packet.PacketInformation;

@PacketInformation(
    listeners = "84,29,68,75,93"
)
public class FrameInteractionPacketHandler extends PacketHandler {
    private static final int WINDOW_SWITCH_PACKET = 93;

    public FrameInteractionPacketHandler() {
    }

    public void handle(Player player, Integer packetId, Integer length, InputStream stream) {
        if (packetId == 68 || packetId == 84) {
            player.getInterfaceManager().setClientActive(true);
            player.setActivated();
        }

        if (packetId == 93) {
            int active = stream.readByte();
            player.getInterfaceManager().setClientActive(active == 1);
        }
    }
}
