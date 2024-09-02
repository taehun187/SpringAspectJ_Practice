package com.taehun.aspectj.declaringadvice.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	@Before("execution(* com.taehun.aspectj.declaringadvice.service.*.*(..))")
	public void logBeforeMethod(JoinPoint jp) {
		System.out.println("logBeforeMethod Advice");
		System.out.println("Class: " + jp.getTarget().getClass().getName());
		System.out.println("Method: " + jp.getSignature().getName());		
	}
	
	@AfterReturning(
			pointcut = "execution(* com.taehun.aspectj.declaringadvice.service.*.*(..))",
			returning = "result"
			)
	public void logAfterReturning(JoinPoint jp, Object result) {
		System.out.println("logAfterReturning Advice");
		System.out.println("Class: " + jp.getTarget().getClass().getName());
		System.out.println("Method: " + jp.getSignature().getName());
		System.out.println("Method return: " + result);
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.taehun.aspectj.declaringadvice.service.*.*(..))",
			throwing = "error"
			)
	public void logAfterThrowing(JoinPoint jp, Throwable error) {
		System.out.println("logAfterThrowing Advice");
		System.out.println("Class: " + jp.getTarget().getClass().getName());
		System.out.println("Method: " + jp.getSignature().getName());
		System.out.println("Method threw exception: " + error);
	}
	
	@After("execution(* com.taehun.aspectj.declaringadvice.service.*.*(..))")
	public void logAfterFinally(JoinPoint jp) {
		System.out.println("logAfterFinally Advice");
		System.out.println("Class: " + jp.getTarget().getClass().getName());
		System.out.println("Method: " + jp.getSignature().getName());
	}	
}
