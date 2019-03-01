package top.jackie.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIO {

    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("E:/A/nio.txt", "rw");
        FileChannel fc = raf.getChannel();
        ByteBuffer bb = ByteBuffer.allocate(8);
        int readed = fc.read(bb);
        while (readed != -1) {
            System.out.println("Read: " + readed);
            bb.flip();
            while (bb.hasRemaining()) {
                System.out.print((char) bb.get());
            }
            bb.clear();
            readed = fc.read(bb);
        }
        raf.close();
    }

}
