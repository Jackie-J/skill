package top.jackie.proxy.dynamic;

public class LouisKoo implements Star {

    @Override
    public void sing(String song) {
        System.out.println("LouisKoo is singing " + song + " !");
    }

    @Override
    public String dance() {
        return "LouisKoo dances so handsome !";
    }

}
