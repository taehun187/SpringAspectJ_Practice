package com.taehun.aspectj.combinedpointcut;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.taehun.aspectj.combinedpointcut.service.MyService;
import com.taehun.aspectj.combinedpointcut.config.AppConfig;
import com.taehun.aspectj.combinedpointcut.dao.MyDao;
import com.taehun.aspectj.combinedpointcut.web.WebController;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		
		WebController webController =
				(WebController) context.getBean("webController"/*, WebController.class*/);
		
		MyService myService = 
				(MyService) context.getBean("myService");
		
		MyDao myDao = 
				(MyDao) context.getBean("myDao");
		
		webController.handleRequest();
		myService.performBusinessLogic();
		myDao.accessData();

	}

}

