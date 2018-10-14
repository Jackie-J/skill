package top.jackie.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {

    private int i = 0;

    public static void main(String[] args) {
        Predicate<String> p = (String s) -> {
            return "abc".equals(s) ? true : false;
        };
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("aaa");
        List<String> result = filter(list, p);
        System.out.println(result);

        Predicate<Integer> p1 = (Integer a) -> a > 0;
        test4();

    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                results.add(t);
            }
        }
        return results;
    }

    public void test() {
        Runnable r = () -> {
            System.out.println(i);
        };
        i = 1;
    }

    public void test2() {
        int a = 1;
        NullToVoid n = () -> {
            System.out.println(a);
        };
    }

    public static void test3() {
        Supplier<Apple> s = Apple::new;
        Apple a = s.get();

        Supplier<Apple> s1 = () -> new Apple();

        Function<Integer, Apple> f = Apple::new;
        f.apply(110);

        Function<Integer, Apple> f2 = w -> new Apple(w);

        Function<String, String> addHeader = Letter::addHeader;
        addHeader = addHeader.andThen(Letter::checkSpelling).andThen(Letter::AddFooter);
        System.out.println(addHeader.apply("labda"));
    }

    public static List<Apple> listApples() {
        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(20, "red"));
        apples.add(new Apple(30, "red"));
        apples.add(new Apple(40, "green"));
        apples.add(new Apple(50, "yellow"));
        return apples;
    }
    
    public static void test4() {
        List<String> s = listApples().stream().map(Apple::getColor).collect(Collectors.toList());
        
//        new Thread(() -> {
//            for (int i = 0; i < 100000; i++) {
//                s.add("a");
//            }
//        }).start();
//
//        new Thread(() -> s.stream().forEach(System.out::println)).start();
        
        if (s.stream().anyMatch("red"::equals)) {
            System.out.println("red");
        }
        
        
    }

}
