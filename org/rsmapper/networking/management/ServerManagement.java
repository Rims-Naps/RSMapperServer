//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.networking.management;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

public class ServerManagement {
    private ServerBootstrap bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool(), 1));
    private static final ServerManagement INSTANCE = new ServerManagement();
    private static final int PORT = 43596;

    private ServerManagement() {
    }

    public void listen() {
        this.bootstrap.setPipelineFactory(new ServerManagementFactory());
        this.bootstrap.setOption("reuseAddress", true);
        this.bootstrap.setOption("child.tcpNoDelay", true);
        this.bootstrap.setOption("child.connectTimeoutMillis", 999999999999999999L);
        this.bootstrap.setOption("child.TcpAckFrequency", true);
        this.bootstrap.bind(new InetSocketAddress(43596));
        System.out.println("Listening on port 43596");
    }

    public static ServerManagement getInstance() {
        return INSTANCE;
    }
}
