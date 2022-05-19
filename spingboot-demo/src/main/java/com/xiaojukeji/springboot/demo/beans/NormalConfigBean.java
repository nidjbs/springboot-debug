package com.xiaojukeji.springboot.demo.beans;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author huayuanlin on 2022/5/19
 */
@Configuration
public class NormalConfigBean implements ApplicationContextAware {


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("NormalBean#setApplicationContext");
	}

	@Bean
	public MyConfig myConfig() {
		return new MyConfig();
	}

	public static class MyConfig {

	}

}