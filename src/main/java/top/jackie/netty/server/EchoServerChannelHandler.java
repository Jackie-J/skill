package top.jackie.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

@Sharable
public class EchoServerChannelHandler extends ChannelInboundHandlerAdapter {

    /**
     * always be invoked when message come in 
     * 对于每个传入的消息都要调用
     */
    @Override
    public void channelRead(ChannelHandlerContext context, Object data) {
        ByteBuf in = (ByteBuf) data;
        System.out.println("Server received: " + in.toString(CharsetUtil.UTF_8));
        context.write(data);
    }

    /**
     * 通知ChannelInboundHandler 最后一次对channel-
    Read()的调用是当前批量读取中的最后一条消息
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext context) {
        context.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }

    /**
     * 在读取操作期间，有异常抛出时会调用
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext context, Throwable cause) {
        cause.printStackTrace();
        context.close();
    }

}
