package top.jackie.service;

import org.springframework.stereotype.Service;

import top.jackie.aop.LogAround;
import top.jackie.aop.LogBefore;
import top.jackie.aop.LogAfter;

@Service
public class TestService {

    @LogBefore(value = "this is message!!! @LogBefore")
    public int before(int c) {
        return c;
    }

    @LogAfter(value = "this is message!!! @LogReturn")
    public int after(int c) {
        return c;
    }

    @LogAround(value = "this is message!!! @LogAround")
    public int around(int c) {
        return c;
    }

}
