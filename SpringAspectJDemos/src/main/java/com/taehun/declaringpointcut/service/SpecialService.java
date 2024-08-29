package com.taehun.declaringpointcut.service;

import com.taehun.declaringpointcut.annotation.Loggable;
import com.taehun.declaringpointcut.annotation.SpecialComponent;
import com.taehun.declaringpointcut.annotation.Validated;

@SpecialComponent
public class SpecialService {
	
	@Loggable
	public void specialOperation(String operation) {
		System.out.println("*******************************************************");
		System.out.println("Performing special operation: " + operation);
		System.out.println("*******************************************************");
	}
	
	public void anotherSpecialOperation(@Validated String parameter) {
		System.out.println("*******************************************************");
		System.out.println("Performing another special operation: " + parameter);
		System.out.println("*******************************************************");
	}

}
                 