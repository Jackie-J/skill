package top.jackie.handler;

import java.lang.reflect.Method;
import java.util.Map;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class ProxyFactory implements MethodInterceptor {

    private Object source;

    private Object convertor;

    private Map<String, MappingInfo> infos;

    public ProxyFactory(Map<String, MappingInfo> infos) {
        this.infos = infos;
    }

    public ProxyFactory(Object convertor, Map<String, MappingInfo> infos) {
        this.convertor = convertor;
        this.infos = infos;
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        String getterName = method.getName();
        Object value = null;
        if (infos.containsKey(getterName)) {
            MappingInfo info = infos.get(getterName);
            Method sourceGetter = info.getSourceGetter();
            Method convertMethod = info.getConvertMethod();
            Object sourceValue = sourceGetter.invoke(source);
            value = convertMethod.invoke(convertor, sourceValue);
        } else {
            value = methodProxy.invokeSuper(proxy, args);
        }
        return value;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public void setConvertor(Object convertor) {
        this.convertor = convertor;
    }

}
