package top.jackie.proxy.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class StarProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("Start " + method.getName());
        Object value = methodProxy.invokeSuper(proxy, args);
        System.out.println("End " + method.getName());
        return value;
    }

}
