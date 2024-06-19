//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.networking.protocol;

import org.rsmapper.game.player.Player;
import org.rsmapper.networking.Session;
import org.rsmapper.networking.codec.Decoder;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.utilities.misc.Utils;
import org.rsmapper.utilities.security.IsaacKeyPair;

public final class ClientPacketsDecoder extends Decoder {
    public ClientPacketsDecoder(Session connection) {
        super(connection);
    }

    public final void decode(InputStream stream) {
        this.session.setDecoder(-1);
        int packetId = stream.readUnsignedByte();
        switch (packetId) {
            case 14:
                this.decodeLogin(stream);
                break;
            case 15:
                this.decodeGrab(stream);
                break;
            case 16:
                this.decodeBotLogin(stream);
                break;
            default:
                this.session.getChannel().close();
                System.out.println("Received packetId " + packetId + " so closed session");
        }

    }

    public void decodeBotLogin(InputStream stream) {
        this.session.setEncoder(1);
        int[] isaacKeys = new int[4];

        for(int i = 0; i < isaacKeys.length; ++i) {
            isaacKeys[i] = stream.readInt();
        }

        if (stream.readLong() != 0L) {
            this.session.getLoginPackets().sendClientPacket(10);
        }

        String password = stream.readString();
        String username = Utils.formatPlayerNameForProtocol(stream.readString());
        int displayMode = stream.readUnsignedByte();
        int screenWidth = stream.readUnsignedShort();
        int screenHeight = stream.readUnsignedShort();
        Player player = new Player(password);
        player.init(this.session, username, displayMode, screenWidth, screenHeight, new IsaacKeyPair(isaacKeys), "mac");
        this.session.getLoginPackets().sendLoginDetails(player);
        this.session.setDecoder(3, player);
        this.session.setEncoder(2, player);
        player.setPassword(password);
        player.start(System.currentTimeMillis());
    }

    private final void decodeLogin(InputStream stream) {
        if (stream.getRemaining() != 0) {
            this.session.getChannel().close();
            System.err.println("Remaining from decoding login wasnt 0 so closed session");
        } else {
            this.session.setDecoder(2);
            this.session.setEncoder(1);
            this.session.getLoginPackets().sendStartUpPacket();
        }
    }

    private final void decodeGrab(InputStream stream) {
        if (stream.getRemaining() != 8) {
            System.err.println("Invalid remaining amount: " + stream.getRemaining());
            this.session.getChannel().close();
        } else {
            this.session.setEncoder(0);
            int build = stream.readInt();
            boolean readsub = true;
            if (readsub) {
                int sub = stream.readInt();
                if (build != 666 || sub != 3) {
                    this.session.setDecoder(-1);
                    this.session.getGrabPackets().sendOutdatedClientPacket();
                    return;
                }
            }

            this.session.setDecoder(1);
            this.session.getGrabPackets().sendStartUpPacket();
        }
    }
}
