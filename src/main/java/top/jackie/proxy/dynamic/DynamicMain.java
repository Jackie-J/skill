package top.jackie.proxy.dynamic;

public class DynamicMain {

    public static void main(String[] args) {
        Star louisKoo = ProxyFactory.create(LouisKoo.class, new StarProxy(new LouisKoo()));
        louisKoo.sing("I like to move it");
        System.out.println(louisKoo.dance());
    }

}
