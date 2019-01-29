package top.jackie;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.assertj.core.util.Sets;
import org.junit.Test;

public class Tests {

    @Test
    public void test() {
        List<String> list = new ArrayList<>();
        Set<String> set = Sets.newHashSet(list);
        System.out.println(set.size());
    }

    public static void main(String[] args) {
        System.out.println(new Date(1543569839525L));

        System.out.println(new Date(1543477245383L));
    }

}
