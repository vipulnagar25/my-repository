package com.reactive.orgi_portal.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AopAspect {
    @After(value = "execution(* com.reactive.orgi_portal.service.OgriUserServiceImpl.*(..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("after execution of {}" + joinPoint.getSignature().getName());
    }

    @Before(value = "execution(* com.reactive.orgi_portal.service.OgriUserServiceImpl.*(..))")
    public void before(JoinPoint joinPoint) {

        System.out.println("before execution of {}" + joinPoint.getSignature().getName());
    }

    @Around(value = "execution(* com.reactive.orgi_portal.service.OgriUserServiceImpl.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around execution of  begin{}" + joinPoint.getSignature().getName());
      Object obj=  joinPoint.proceed();
        System.out.println("Around execution of  end{}" + joinPoint.getSignature().getName());
        return obj;
    }

    public static String convertObjToJSONFormat(Object obj) {
        ObjectMapper mapper = new ObjectMapper();
        String stringVal = null;
        try {
            stringVal = mapper.writeValueAsString(obj);
            System.out.println(stringVal);
        } catch (Exception e) {
            System.out.println(e);
        }
        return stringVal;
    }
}
