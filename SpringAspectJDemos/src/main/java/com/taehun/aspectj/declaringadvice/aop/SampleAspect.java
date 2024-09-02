package com.taehun.aspectj.declaringadvice.aop;

import java.lang.reflect.Method;
import java.util.Collection;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;

import com.taehun.aspectj.declaringadvice.annotation.AuditCode;
import com.taehun.aspectj.declaringadvice.annotation.AuditableCode;
import com.taehun.aspectj.declaringadvice.model.MyType;


@Aspect
@Component
public class SampleAspect {

	@Before("execution(* com.taehun.aspectj.declaringadvice.service.Sample+.sampleGenericMethod(*)) "
			+ "&& args(param)")
	public void beforeSampleMethod(JoinPoint jp, MyType param) {
		System.out.println("beforeSampleMethod: Before sampleGeneric with MyType parm: " 
				+ param);
	}
	
	@Before("execution(* com.taehun.aspectj.declaringadvice.service.Sample+.sampleGenericCollectionMethod(*)) "
			+ "&& args(param)")
	public void beforeGenericCollectionSampleMethod(JoinPoint jp, Collection<?> param) {
		System.out.println("beforeGenericCollectionSampleMethod: Before sampleGenericCollectionMethod with Collection parm: " 
				+ param);
		
		if (!param.isEmpty()) {
			Object firstElement = param.iterator().next();
			
			if (firstElement instanceof MyType) {
				System.out.println("First element in collection is of type MyType: " 
						+ firstElement);
			}
		}
	}
	
	
	@Before("execution(* com.taehun.aspectj.declaringadvice.service.Sample+.sampleGenericMethod(*)) "
			+ "&& args(param)")
	public void beforeSampleMethodForDetermingArgumentName(JoinPoint jp, MyType param) {
		System.out.println("--beforeSampleMethodForDetermingArgumentName--");
		MethodSignature methodSignature = (MethodSignature)jp.getSignature();
		Method method =  methodSignature.getMethod();
		
		ParameterNameDiscoverer pnd = new StandardReflectionParameterNameDiscoverer();
		String[] parameterNames = pnd.getParameterNames(method);
		
		if (parameterNames != null) {
			for(String paraName : parameterNames) {
				System.out.println("Determined parameter name: " + paraName);
			}
		} else {
			System.out.println("No parameter names found");
		}
		System.out.println("++beforeSampleMethodForDetermingArgumentName++");

	}
	
	// argNames: 
	// 디버그 정보 없이 컴파일하거나, 
	// 런타임에 "포인트컷을 해석하는 경우에는 advice 선언에 사용된 아규먼트의 이름[bean, auditablecode]을 사용할 수 없습니다". 
	// 이러한 상황에서만 @Before 어노테이션에 아규먼트 이름[argNames]을 제공해야 합니다. 
	// 이는 아규먼트[@Before]가 달린 메서드[audit]에서 사용된 이름과 반드시 ​​동일해야 합니다. 
	// 형식은 간단한 쉼표로 구분된 목록입니다.
	@Before(value = "execution(* com.taehun.aspectj.declaringadvice.service.SampleService.*(..))"
			+ " && target(bean) && @annotation(auditablecode)",
			argNames = "bean,auditablecode")
	public void audit(Object bean, AuditableCode auditablecode) {
		AuditCode code = auditablecode.value();
		System.out.println("Audit1 - Bean: " + bean.getClass().getName() + ", Code: " +  code);
	}
	
	@Before(value = "execution(* com.taehun.aspectj.declaringadvice.service.SampleService.*(..))"
			+ " && target(bean) && @annotation(auditablecode)",
			argNames = "jp,bean,auditablecode")
	public void audit(JoinPoint jp, Object bean, AuditableCode auditablecode) {
		AuditCode code = auditablecode.value();
		System.out.println("Method: " + jp.getSignature().getName());
		System.out.println("Audit2 - Bean: " + bean.getClass().getName() + ", Code: " +  code);
	}
	
	
}
