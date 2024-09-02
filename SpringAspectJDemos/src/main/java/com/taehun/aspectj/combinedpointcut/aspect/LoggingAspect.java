package com.taehun.aspectj.combinedpointcut.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	@Pointcut("com.taehun.aspectj.combinedpointcut.pointcuts.CommonPointcuts.inWebLayer()"
			+ "&& execution(public * *(..))")
	public void publicWebLayerOperation() {}
	
	@Pointcut("com.taehun.aspectj.combinedpointcut.pointcuts.CommonPointcuts.businessService()"
			+ "&& !com.taehun.aspectj.combinedpointcut.pointcuts.CommonPointcuts.inDataAccessLayer()")
	public void transactionServiceOperation() {}
	
	@Pointcut("publicWebLayerOperation() || transactionServiceOperation() ")
	public void webOrTranscationalServiceOperation() {}
	
	// JoinPoint 인터페이스 name에 주의하자!!!
	// org.aopalliance.intercept 패키지의 Joinpoint와 혼동하지 말것!!!
	// 우리가 사용할 조인포인트는 org.aspectj.lang.JoinPoint 임!!!
	@Before("publicWebLayerOperation()")
	public void logBeforePublicWebOperation(JoinPoint joinpoint) {
		System.out.println("logBeforePublicWebOperation advice");
		System.out.println("Method: " + joinpoint.getSignature().getName());
	}
	
	@Before("transactionServiceOperation()")
	public void logBeforeTransactionalServiceOperation(JoinPoint joinpoint) {
		System.out.println("logBeforeTransactionalServiceOperation advice");
		System.out.println("Method: " + joinpoint.getSignature().getName());
	}
	
	@Before("webOrTranscationalServiceOperation()")
	public void logBeforeWebOrTransactionalOperation(JoinPoint joinpoint) {
		System.out.println("logBeforeWebOrTransactionalOperation advice");
		System.out.printf("Target Class:%s \n Method:%s \n", 
				joinpoint.getTarget().getClass().getName(), 
				joinpoint.getSignature().getName());
	}
}
