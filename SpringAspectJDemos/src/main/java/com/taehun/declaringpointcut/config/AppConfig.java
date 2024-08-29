package com.taehun.declaringpointcut.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.taehun.declaringpointcut.service.SpecialService;
import com.taehun.declaringpointcut.service.TransferService;

@Configuration
@ComponentScan(basePackages = "com.taehun.declaringpointcut")
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public SpecialService specialService() {
        return new SpecialService(); 
    }
    @Bean
    public TransferService transferService() {
    	return new TransferService();
    }
    
}
