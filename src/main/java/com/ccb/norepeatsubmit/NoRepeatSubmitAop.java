

package com.ccb.norepeatsubmit;


import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.concurrent.TimeUnit;


@Aspect
@Component
public class NoRepeatSubmitAop {


    private Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private StringRedisTemplate redisTemplates;

    @Around("execution(* com.ccb..*Controller.*(..)) && @annotation(nrs)")
    public Object arround(ProceedingJoinPoint pjp, NoRepeatSubmit nrs) {
        ValueOperations<String, Integer> opsForValue;
       // opsForValue = StringRedisTemplate.opsForValue();
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
            HttpServletRequest request = attributes.getRequest();
            String key = sessionId + "-" + request.getServletPath();
            System.out.println("-----------------"+key);
          //  System.out.println((redisTemplates.opsForValue().get(key).toString());
            boolean flag=redisTemplates.hasKey(key);
            System.out.println(flag);
            if (redisTemplates.hasKey(key)) {// 如果缓存中有这个url视为重复提交
                logger.error("重复提交");
                return null;

            } else {
                Object o = pjp.proceed();
                redisTemplates.opsForValue().set(key, "2", 2, TimeUnit.SECONDS );
                return o;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            logger.error("验证重复提交时出现未知异常!");
            return "{\"code\":-889,\"message\":\"验证重复提交时出现未知异常!\"}";
        }

    }

}
