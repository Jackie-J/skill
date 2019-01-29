package top.jackie.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.JoinPoint.StaticPart;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAdvice {

    @Pointcut("@annotation(top.jackie.aop.LogBefore)")
    public void LogBeforePointcut() {
        
    }

    @Pointcut("@annotation(top.jackie.aop.LogAfter)")
    public void LogAfterPointcut() {
    }

    @Pointcut("@annotation(top.jackie.aop.LogAround)")
    public void LogAroundPointcut() {
    }

    @Before(value = "LogBeforePointcut()")
    public void before(JoinPoint point) {
        Method method = getMethod(point);
        LogBefore log = method.getAnnotation(LogBefore.class);
        String msg = log.value();
        LogLevel level = log.level();
        Opt opt = log.opt();
        if (opt == Opt.NONE) {
            // TODO 获取方法名称
        }
    }

    @AfterReturning(pointcut = "LogAfterPointcut()")
    public void afterReturn(JoinPoint point) {
        Method method = getMethod(point);
    }

    @Around(value = "LogAroundPointcut()")
    public void around(JoinPoint point) {
        Method method = getMethod(point);
    }

    private Method getMethod(JoinPoint point) {
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        return method;
    }

    // @AfterThrowing(pointcut = "LogBeforePointcut()", throwing = "e")
    // public void logException(JoinPoint point, Exception e) {
    // Signature signature = point.getSignature();
    // MethodSignature methodSignature = (MethodSignature) signature;
    // Method method = methodSignature.getMethod();
    // Log log = method.getAnnotation(Log.class);
    //
    // Object[] obs = point.getArgs();
    // Class<?> c = point.getClass();
    // String k = point.getKind();
    //
    // SourceLocation sl = point.getSourceLocation();
    // StaticPart sp = point.getStaticPart();
    // Object target = point.getTarget();
    // Class<?> cc = target.getClass();
    // Object ts = point.getThis();
    // System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
    // }

    // @AfterThrowing(value = "@annotation(log)", throwing = "e")
    // public void logException(JoinPoint point, Exception e, Log log) {
    //
    // Object[] obs = point.getArgs();
    // Class<?> c = point.getClass();
    // String k = point.getKind();
    //
    // SourceLocation sl = point.getSourceLocation();
    // StaticPart sp = point.getStaticPart();
    // Object target = point.getTarget();
    // Object ts = point.getThis();
    // System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>");
    // }

}
