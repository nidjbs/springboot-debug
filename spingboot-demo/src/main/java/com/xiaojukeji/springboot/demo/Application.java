package com.xiaojukeji.springboot.demo;

import com.xiaojukeji.springboot.demo.beans.CircularReferenceTest;
import com.xiaojukeji.springboot.demo.beans.FactoryBeanObj;
import com.xiaojukeji.springboot.demo.beans.FactoryBeanTest;
import com.xiaojukeji.springboot.demo.beans.MyLifecycleBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author huayuanlin on 2022/5/16
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableRetry()
@EnableAsync
@EnableAspectJAutoProxy(exposeProxy = true)
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		CircularReferenceTest bean = applicationContext.getBean(CircularReferenceTest.class);
		System.out.println();
	}

}