package top.jackie.handler;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import top.jackie.annotation.Mapping;
import top.jackie.annotation.Mappings;

public class ProcessFactory {

    public <S, T> List<MappingInfo> init(Class<S> source, Class<T> target) {
        List<MappingInfo> infos = new ArrayList<>();
        List<Field> fields = this.listAllField(source);
        if (fields != null && fields.size() > 0) {
            for (Field field : fields) {
                Mappings mappings = field.getAnnotation(Mappings.class);
                if (mappings != null) {
                    Mapping[] annotations = mappings.mappings();
                    for (Mapping annotation : annotations) {
                        infos.addAll(this.analyze(source, target, annotation));
                    }
                } else {
                    Mapping annotation = field.getAnnotation(Mapping.class);
                    infos.addAll(this.analyze(source, target, annotation));
                }
            }
        }
        return infos;
    }

    public <S, T> List<MappingInfo> analyze(Class<S> source, Class<T> target, Mapping annotation) {
        List<MappingInfo> infos = new ArrayList<>();
        return infos;
    }

    /**
     * 获取类的所有字段，包括父类的所有字段
     * @param clasz
     * @return
     */
    private List<Field> listAllField(Class<?> clasz) {
        List<Field> fieldList = new ArrayList<>();
        do {
            Field[] fields = clasz.getDeclaredFields();
            if (fields != null && fields.length > 0) {
                fieldList.addAll(Arrays.asList(fields));
            }
            clasz = clasz.getSuperclass();
        } while (clasz != null);
        return fieldList;
    }

}
