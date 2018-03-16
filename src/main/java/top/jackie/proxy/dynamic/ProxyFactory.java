package top.jackie.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static <T> T create(Class<T> clasz, InvocationHandler handler) {
        @SuppressWarnings("unchecked")
        T t = (T) Proxy.newProxyInstance(clasz.getClassLoader(), clasz.getInterfaces(), handler);
        return t;
    }

}
