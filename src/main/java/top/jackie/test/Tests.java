package top.jackie.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class Tests {

    @PostConstruct
    public void init() {
        System.out.println(Config.days);
        System.out.println(Config.once);

        System.out.println(new Date(1539218996524L));

        System.out.println(new Date(1539219011524L));
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf.format(new Date(1540543024083L)));

        System.out.println(sdf.format(new Date(1540542879939L)));
    }

}
