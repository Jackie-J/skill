package top.jackie.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class SocketServer {

    public static void main(String[] args) {
        try {
            ServerSocketChannel ssc = ServerSocketChannel.open();
            ssc.socket().bind(new InetSocketAddress("127.0.0.1", 1234));
            ssc.configureBlocking(false);

            Selector selector = Selector.open();

            ssc.register(selector, SelectionKey.OP_ACCEPT);

            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
            writeBuffer.put("callback: ".getBytes());
            writeBuffer.flip();

            while (true) {
                // 一旦调用select()方法，并且返回值不为0时，
                // 则 可以通过调用Selector的selectedKeys()
                // 方法来访问已选择键集合
                if (selector.select() == 0) {
                    return;
                }
                Set<SelectionKey> selectKeys = selector.selectedKeys();
                Iterator<SelectionKey> it = selectKeys.iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();
                    if (key.isAcceptable()) {
                        System.out.println("connected");
                        SocketChannel sc = ssc.accept();
                        sc.configureBlocking(false);
                        sc.register(selector, SelectionKey.OP_READ);
                    } else if (key.isReadable()) {
                        System.out.println("readed");
                        SocketChannel sc = (SocketChannel) key.channel();
                        readBuffer.clear();
                        sc.read(readBuffer);
                        readBuffer.flip();
                        System.out.println("received: " + new String(readBuffer.array()));
                        key.interestOps(SelectionKey.OP_WRITE);
                    } else if (key.isWritable()) {
                        System.out.println("writed");
                        writeBuffer.rewind();
                        SocketChannel socketChannel = (SocketChannel) key.channel();
                        socketChannel.write(writeBuffer);
                        key.interestOps(SelectionKey.OP_READ);
                    }
                }
                Thread.sleep(1000);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
