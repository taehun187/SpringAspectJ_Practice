package com.taehun.aspectj.combinedpointcut.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "com.taehun.aspectj.combinedpointcut")
public class AppConfig {
	
	

}
