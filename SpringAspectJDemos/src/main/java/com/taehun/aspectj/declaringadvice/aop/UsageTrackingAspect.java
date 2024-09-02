package com.taehun.aspectj.declaringadvice.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

import com.taehun.aspectj.declaringadvice.model.DefaultUsageTracked;
import com.taehun.aspectj.declaringadvice.model.UsageTracked;

@Aspect
@Component
public class UsageTrackingAspect {

	@DeclareParents(value="com.taehun.aspectj.declaringadvice.service.*+", 
			defaultImpl = DefaultUsageTracked.class)
	public static UsageTracked mixin;
	
	
	@Before("execution(* com.taehun.aspectj.declaringadvice.service.*.*(..)) "
			+ "&& this(usageTracked)")
	public void trackUsage(UsageTracked usageTracked) {
		usageTracked.incrementUseCount();
		System.out.println("Usage count incremented: " + usageTracked.getUseCount());
	}
}
