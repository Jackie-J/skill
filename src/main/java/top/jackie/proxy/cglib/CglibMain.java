package top.jackie.proxy.cglib;

public class CglibMain {

    public static void main(String[] args) {
        AndyLau andyLau = ProxyFactory.create(AndyLau.class, new StarProxy());
        andyLau.sing("I like to move it");
        System.out.println(andyLau.dance());
    }

}
