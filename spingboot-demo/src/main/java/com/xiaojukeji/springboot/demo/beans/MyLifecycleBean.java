package com.xiaojukeji.springboot.demo.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author huayuanlin on 2022/5/17
 */
@Component
public class MyLifecycleBean implements InitializingBean, ApplicationContextAware, DisposableBean {

	@PostConstruct
	public void initTest() {
		System.out.println("MyLifecycleBean#postConstruct");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("MyLifecycleBean#afterPropertiesSet");
	}


	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("MyLifecycleBean#setApplicationContext");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("MyLifecycleBean#destroy");
	}
}