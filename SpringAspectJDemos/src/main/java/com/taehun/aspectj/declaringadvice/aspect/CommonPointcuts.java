package com.taehun.aspectj.declaringadvice.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcuts {
	
	@Pointcut("within(com.taehun.aspectj.declaringadvice.service..*)")
	public void inDataAccessLayer() {
		
	}
}
