package com.px.sp_boot.common.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LogWebRequest {

    private Logger logger = LoggerFactory.getLogger(LogWebRequest.class);

    @Pointcut("execution(public * com.px.sp_boot.web.*.*(..))")
    public void httpRequestPointCut(){}

    @Before("httpRequestPointCut()")
    public void before(JoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        logger.info("======================================= http request start ====================================");
        logger.info("=");
        logger.info("= from= {}", request.getSession().getAttribute("username"));
        logger.info("= url= {}", request.getRequestURL());
        logger.info("= method= {}", request.getMethod());
        logger.info("= ip= {}", request.getRemoteAddr());
        logger.info("= user= {}", request.getRemoteUser());
        logger.info("= class= {}", joinPoint.getSignature().getDeclaringTypeName());
        logger.info("= method= {}", joinPoint.getSignature().getName());
        logger.info("= args= {}", joinPoint.getArgs());
        logger.info("=");
        logger.info("===============================================================================================");
    }

    @AfterReturning(returning = "object", pointcut = "httpRequestPointCut()")
    public void afterReturning(Object object){
        logger.info("======================================== http request end =====================================");
        logger.info("=");
        logger.info("= response= {}", object);
        logger.info("=");
        logger.info("===============================================================================================");
    }
}
