package top.jackie.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Predicate<String> p = (String s) -> {
            return "abc".equals(s) ? true : false;
        };
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("aaa");
        List<String> result = filter(list, p);
        System.out.println(result);
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

}
