package top.jackie.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

public class ProxyFactory {

    public static <T> T create(Class<T> clasz, MethodInterceptor interceptor) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clasz);
        enhancer.setCallback(interceptor);
        @SuppressWarnings("unchecked")
        T t = (T) enhancer.create();
        return t;
    }

}
