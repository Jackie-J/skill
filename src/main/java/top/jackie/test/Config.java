package top.jackie.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Config {

    @Value(value = "${init.sync.days}")
    public static Integer days;

    public static final int once = 30;

}
