package top.jackie.test;

public class Binary {

    public static void main(String[] args) {
        int binary = 0b1;
        int octonary = 07;
        int hexadecimal = 0x0F;

        System.out.println("二进制输出：" + Integer.toBinaryString(binary));

        // 按8进制输出
        System.out.println("八进制输出：" + Integer.toOctalString(octonary));
        System.out.printf("八进制输出：%o\n", octonary);
        // 按16位十六进制输出，向右靠齐，左边用0补齐
        System.out.printf("八进制输出：" + "%016o\n", octonary);

        // 按16进制输出
        System.out.println("十六进制输出：" + Integer.toHexString(hexadecimal));
        System.out.printf("十六进制输出：%x\n", hexadecimal);
        // 按10位八进制输出，向右靠齐，左边用0补齐
        System.out.printf("十六进制输出" + "%016x\n", hexadecimal);

        System.out.println(new byte[] { 0x0F }.length);

        System.out.println(new byte[] { 127 }[0]);

    }

}
