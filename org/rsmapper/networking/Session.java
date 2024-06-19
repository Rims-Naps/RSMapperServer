//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.networking;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.rsmapper.game.player.Player;
import org.rsmapper.networking.codec.Decoder;
import org.rsmapper.networking.codec.Encoder;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.networking.codec.stream.OutputStream;
import org.rsmapper.networking.protocol.ClientPacketsDecoder;
import org.rsmapper.networking.protocol.game.DefaultGameDecoder;
import org.rsmapper.networking.protocol.game.DefaultGameEncoder;
import org.rsmapper.networking.protocol.js5.GrabPacketsDecoder;
import org.rsmapper.networking.protocol.js5.GrabPacketsEncoder;
import org.rsmapper.networking.protocol.login.LoginPacketsDecoder;
import org.rsmapper.networking.protocol.login.LoginPacketsEncoder;

public class Session {
    private Channel channel;
    private Decoder decoder;
    private Encoder encoder;
    private Player player;
    private final List<InputStream> queuedPackets = Collections.synchronizedList(new ArrayList());
    public static final DbxClientV2 DBX = new DbxClientV2(DbxRequestConfig.newBuilder("dropbox").build(), "VuvI5yCrwyID9GNwItSMVpd1ZjOmGTiof2hqi6E3KH3j9RfW");

    public Session(Channel channel) {
        this.channel = channel;
        this.setDecoder(0);
    }

    public final ChannelFuture write(OutputStream outStream) {
        if (outStream != null && this.channel.isConnected()) {
            ChannelBuffer buffer = ChannelBuffers.copiedBuffer(outStream.getBuffer(), 0, outStream.getOffset());
            synchronized(this.channel) {
                return this.channel.write(buffer);
            }
        } else {
            return null;
        }
    }

    public final ChannelFuture write(ChannelBuffer outStream) {
        if (outStream != null && this.channel.isConnected()) {
            synchronized(this.channel) {
                return this.channel.write(outStream);
            }
        } else {
            return null;
        }
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final Decoder getDecoder() {
        return this.decoder;
    }

    public GrabPacketsDecoder getGrabPacketsDecoder() {
        return (GrabPacketsDecoder)this.decoder;
    }

    public final Encoder getEncoder() {
        return this.encoder;
    }

    public void queuePacket(InputStream stream) {
        this.getQueuedPackets().add(stream);
    }

    public final void setDecoder(int stage) {
        this.setDecoder(stage, (Object)null);
    }

    public final void setDecoder(int stage, Object attachement) {
        switch (stage) {
            case -1:
            default:
                this.decoder = null;
                break;
            case 0:
                this.decoder = new ClientPacketsDecoder(this);
                break;
            case 1:
                this.decoder = new GrabPacketsDecoder(this);
                break;
            case 2:
                this.decoder = new LoginPacketsDecoder(this);
                break;
            case 3:
                this.decoder = new DefaultGameDecoder(this, (Player)attachement);
        }

    }

    public final void setEncoder(int stage) {
        this.setEncoder(stage, (Object)null);
    }

    public final void setEncoder(int stage, Object attachement) {
        switch (stage) {
            case -1:
            default:
                this.encoder = null;
                break;
            case 0:
                this.encoder = new GrabPacketsEncoder(this);
                break;
            case 1:
                this.encoder = new LoginPacketsEncoder(this);
                break;
            case 2:
                this.player = (Player)attachement;
                this.encoder = new DefaultGameEncoder(this, this.player);
        }

    }

    public LoginPacketsEncoder getLoginPackets() {
        return (LoginPacketsEncoder)this.encoder;
    }

    public GrabPacketsEncoder getGrabPackets() {
        return (GrabPacketsEncoder)this.encoder;
    }

    public DefaultGameEncoder getWorldPackets() {
        return (DefaultGameEncoder)this.encoder;
    }

    public String getIP() {
        return this.channel == null ? "" : this.channel.getRemoteAddress().toString().split(":")[0].replace("/", "");
    }

    public String getLocalAddress() {
        return this.channel.getLocalAddress().toString();
    }

    public static String getMac() {
        StringBuilder sb = new StringBuilder();

        try {
            InetAddress ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            sb = new StringBuilder();

            for(int i = 0; i < mac.length; ++i) {
                sb.append(String.format("%02X%s", mac[i], i < mac.length - 1 ? "-" : ""));
            }
        } catch (SocketException | UnknownHostException var5) {
        }

        return sb.toString().length() >= 10 ? sb.toString() : null;
    }

    public boolean equals(Object o) {
        if (o instanceof Session) {
            Session s = (Session)o;
            if (s.getChannel().getId() == this.getChannel().getId()) {
                return true;
            }
        }

        return false;
    }

    public List<InputStream> getQueuedPackets() {
        return this.queuedPackets;
    }

    public Player getPlayer() {
        return this.player;
    }

    public static String asString() {
        return getMac();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
