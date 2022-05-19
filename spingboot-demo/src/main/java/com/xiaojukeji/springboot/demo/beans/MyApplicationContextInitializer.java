package com.xiaojukeji.springboot.demo.beans;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author huayuanlin on 2022/5/17
 */
public class MyApplicationContextInitializer implements ApplicationContextInitializer {

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		System.out.println("MyApplicationContextInitializer#initialize---" + applicationContext.getApplicationName());
	}
}