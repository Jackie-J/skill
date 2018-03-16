package top.jackie.test;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class Tests {

    @PostConstruct
    public void init() {
        System.out.println(Config.days);
        System.out.println(Config.once);
    }

}
