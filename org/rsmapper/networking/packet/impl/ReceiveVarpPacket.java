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
    listeners = "187"
)
public class ReceiveVarpPacket extends PacketHandler {
    public ReceiveVarpPacket() {
    }

    public void handle(Player player, Integer packetId, Integer length, InputStream stream) {
        if (packetId == 187) {
            int varpId1 = stream.readShort();
            int varpValue1 = stream.readInt();
            int varpId2 = stream.readShort();
            int varpValue2 = stream.readInt();
            System.out.println("VARP1[" + varpId1 + "] = " + varpValue1);
            System.out.println("VARP2[" + varpId2 + "] = " + varpValue2);
        }
    }
}
