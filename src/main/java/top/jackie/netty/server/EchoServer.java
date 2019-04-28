package top.jackie.netty.server;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {

    private int port = 89;

    public static void main(String[] args) {
        new EchoServer().start();
        System.out.println("exit");
    }

    public void start() {
        EchoServerChannelHandler serverHandler = new EchoServerChannelHandler();
        EventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap boot = new ServerBootstrap();
        boot.group(group).channel(NioServerSocketChannel.class).localAddress(new InetSocketAddress(port))
                .childHandler(new ChannelInitializer<SocketChannel>() {

                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(serverHandler);
                    }

                });
        try {
            ChannelFuture f = boot.bind().sync();
            System.out.println("begin");
            f.channel().closeFuture().sync();
            System.out.println("end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                group.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
