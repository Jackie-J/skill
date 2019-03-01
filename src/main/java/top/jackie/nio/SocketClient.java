package top.jackie.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketClient {
    
    public static void main(String[] args) {
        try {
            SocketChannel sc = SocketChannel.open();
            sc.connect(new InetSocketAddress("127.0.0.1", 1234));
            
            
            ByteBuffer writeBuffer = ByteBuffer.allocate(32);
            ByteBuffer readBuffer = ByteBuffer.allocate(32);

            writeBuffer.put("hello".getBytes());
            writeBuffer.flip();
            
            while (true) {
                writeBuffer.rewind();
                sc.write(writeBuffer);
                readBuffer.clear();
                sc.read(readBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
