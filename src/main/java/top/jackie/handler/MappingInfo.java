package top.jackie.handler;

import java.lang.reflect.Method;

public class MappingInfo {

    private String getterName;

    private Method sourceGetter;

    private Method convertMethod;

    public MappingInfo() {
    }

    public static MappingInfo newInstance() {
        return new MappingInfo();
    }

    public MappingInfo getterName(String getterName) {
        this.getterName = getterName;
        return this;
    }

    public MappingInfo sourceGetter(Method sourceGetter) {
        this.sourceGetter = sourceGetter;
        return this;
    }

    public MappingInfo convertMethod(Method convertMethod) {
        this.convertMethod = convertMethod;
        return this;
    }

    public String getGetterName() {
        return getterName;
    }

    public void setGetterName(String getterName) {
        this.getterName = getterName;
    }

    public Method getSourceGetter() {
        return sourceGetter;
    }

    public void setSourceGetter(Method sourceGetter) {
        this.sourceGetter = sourceGetter;
    }

    public Method getConvertMethod() {
        return convertMethod;
    }

    public void setConvertMethod(Method convertMethod) {
        this.convertMethod = convertMethod;
    }

}
