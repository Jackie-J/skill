package top.jackie.aop;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface LogAround {

    String value();

    String head() default LogConstants.NONE;

    String tail() default LogConstants.NONE;

    LogLevel level() default LogLevel.INFO;
    
    Opt opt() default Opt.NONE;

}
