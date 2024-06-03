package com.example.StoreSua.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Aspect
@Component
public class RequestLoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(RequestLoggingAspect.class);

    @Around("execution(public * com.example.StoreSua.controller.*.create*(..))")
    public Object logCreateRequest(ProceedingJoinPoint joinPoint) throws Throwable {
        return logRequest(joinPoint, "Create", joinPoint.getArgs());
    }

    @Around("execution(public * com.example.StoreSua.controller.*.read*(..))")
    public Object logReadRequest(ProceedingJoinPoint joinPoint) throws Throwable {
        return logRequest(joinPoint, "Read", joinPoint.getArgs());
    }

    @Around("execution(public * com.example.StoreSua.controller.*.update*(..))")
    public Object logUpdateRequest(ProceedingJoinPoint joinPoint) throws Throwable {
        return logRequest(joinPoint, "Update", joinPoint.getArgs());
    }

    @Around("execution(public * com.example.StoreSua.controller.*.delete*(..))")
    public Object logDeleteRequest(ProceedingJoinPoint joinPoint) throws Throwable {
        return logRequest(joinPoint, "Delete", joinPoint.getArgs());
    }

    private Object logRequest(ProceedingJoinPoint joinPoint, String operation, Object[] args) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getMethod().getName();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String url = request.getRequestURL().toString();
        String ipAddress = request.getRemoteAddr();

        Instant start = Instant.now();
        Object result = joinPoint.proceed();
        Instant end = Instant.now();

        long duration = Duration.between(start, end).toMillis();

        // Định dạng thời gian
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
                .withZone(ZoneId.systemDefault());
        String timestamp = formatter.format(start);

        logger.info("Thời gian: {} - Truy cập URL: {} - Địa chỉ IP: {} - Thao tác: {} - Hoạt động: {} - Nội dung: {} - Thời gian thực thi: {} ms", timestamp, url, ipAddress, methodName, operation, Arrays.toString(args), duration);

        return result;
    }
}
