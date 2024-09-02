package com.taehun.aspectj.declaringadvice.model;

public interface UsageTracked {
	
	void incrementUseCount();
	
	int getUseCount();

}
