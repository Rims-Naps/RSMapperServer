//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.rsmapper.networking.management;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.rsmapper.networking.management.query.ServerQueryHandler;

public class ServerManagementHandler extends SimpleChannelUpstreamHandler {
    public ServerManagementHandler() {
    }

    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
        System.out.println(e.getChannel() + " connected");
        this.sendMessage(e.getChannel(), "Welcome to the Server Management Tool.");
        this.sendMessage(e.getChannel(), "Type 'commands' to view commands.");
    }

    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
        System.out.println(e.getChannel() + " disconnected");
    }

    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
        this.sendMessage(e.getChannel(), ServerQueryHandler.handleQuery(e.getMessage().toString()));
    }

    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
    }

    private void sendMessage(Channel channel, String message) {
        channel.write("\t" + message + "\n");
    }
}
