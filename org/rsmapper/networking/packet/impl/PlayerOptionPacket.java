//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.networking.packet.impl;

import org.rsmapper.game.World;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.player.RouteEvent;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.networking.packet.PacketHandler;
import org.rsmapper.networking.packet.PacketInformation;
import org.rsmapper.utilities.misc.Utils;

@PacketInformation(
    listeners = "14,53,43,77,46"
)
public class PlayerOptionPacket extends PacketHandler {
    private static final int PLAYER_OPTION_1 = 14;
    private static final int PLAYER_OPTION_2 = 53;
    private static final int PLAYER_OPTION_4 = 77;
    private static final int PLAYER_OPTION_9 = 43;
    private static final int ACCEPT_TRADE_CHAT_PACKET = 46;

    public PlayerOptionPacket() {
    }

    public void handle(Player player, Integer packetId, Integer length, InputStream stream) {
        switch (packetId) {
            case 14:
                this.handlePlayerOption1(player, packetId, length, stream);
                break;
            case 43:
                this.handlePlayerOption9(player, packetId, length, stream);
                break;
            case 46:
            case 77:
                this.handlePlayerOption4(player, packetId, length, stream);
                break;
            case 53:
                this.handlePlayerOption2(player, packetId, length, stream);
        }

    }

    private void handlePlayerOption1(Player player, Integer packetId, Integer length, InputStream stream) {
        if (player.hasStarted() && player.clientHasLoadedMapRegion() && !player.isDead()) {
            boolean forceRun = stream.readByte() == 1;
            int playerIndex = stream.readUnsignedShort();
            Player p2 = (Player)World.getPlayers().get(playerIndex);
            if (p2 != null && !p2.isDead() && !p2.hasFinished() && player.getMapRegionsIds().contains(p2.getRegionId())) {
                if (player.getLockDelay() <= Utils.currentTimeMillis() && player.getControllerManager().canPlayerOption1(p2)) {
                    if (player.getControllerManager().canAttack(p2)) {
                        if (forceRun) {
                            player.setRun(forceRun);
                        }

                        if (!p2.isAtMultiArea() || !player.isAtMultiArea()) {
                            if (player.getAttackedBy() != p2 && player.getAttackedByDelay() > Utils.currentTimeMillis()) {
                                player.getPackets().sendGameMessage("You are already in combat.");
                                return;
                            }

                            if (p2.getAttackedBy() != player && p2.getAttackedByDelay() > Utils.currentTimeMillis()) {
                                if (!(p2.getAttackedBy() instanceof NPC)) {
                                    player.getPackets().sendGameMessage("That player is already in combat.");
                                    return;
                                }

                                p2.setAttackedBy(player);
                            }
                        }

                        player.stopAll(false);
                    }
                }
            }
        }
    }

    private void handlePlayerOption2(Player player, Integer packetId, Integer length, InputStream stream) {
        if (player.hasStarted() && player.clientHasLoadedMapRegion() && !player.isDead()) {
            stream.readByte();
            int playerIndex = stream.readUnsignedShort();
            Player p2 = (Player)World.getPlayers().get(playerIndex);
            if (p2 != null && !p2.isDead() && !p2.hasFinished() && player.getMapRegionsIds().contains(p2.getRegionId())) {
                if (!player.isLocked()) {
                    if (player.getControllerManager().canPlayerOption2(p2)) {
                        player.stopAll(false);
                    }
                }
            }
        }
    }

    private void handlePlayerOption4(Player player, Integer packetId, Integer length, InputStream stream) {
        stream.readByte();
        int playerIndex = stream.readUnsignedShort();
        Player p2 = (Player)World.getPlayers().get(playerIndex);
        if (p2 != null && !p2.isDead() && !p2.hasFinished() && player.getMapRegionsIds().contains(p2.getRegionId())) {
            if (player.getLockDelay() <= Utils.currentTimeMillis()) {
                if (player.getControllerManager().canPlayerOption4(p2)) {
                    if (player.isCantTrade()) {
                        player.getPackets().sendGameMessage("You are busy.");
                    } else {
                        player.stopAll(false);
                        player.setRouteEvent(new RouteEvent(p2, new Runnable() {
                            public void run() {
                            }
                        }));
                    }
                }
            }
        }
    }

    private void handlePlayerOption9(Player player, Integer packetId, Integer length, InputStream stream) {
        boolean forceRun = stream.readByte() == 1;
        int playerIndex = stream.readUnsignedShort();
        Player p2 = (Player)World.getPlayers().get(playerIndex);
        if (p2 != null && p2 != player && !p2.isDead() && !p2.hasFinished() && player.getMapRegionsIds().contains(p2.getRegionId())) {
            if (!player.isLocked()) {
                if (forceRun) {
                    player.setRun(forceRun);
                }

                player.stopAll();
            }
        }
    }
}
