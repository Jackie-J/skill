package top.jackie;

import java.util.ArrayList;
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

}
