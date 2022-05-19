package com.xiaojukeji.springboot.demo.beans;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huayuanlin on 2022/5/17
 */
@Configuration
@ConditionalOnWebApplication
public class MyAutoConfiguration {

	@Bean
	public TestBean testAutoConfigurationBean() {
		System.out.println("testAutoConfigurationBean bean init.");
		return new TestBean();
	}

	public static class TestBean{

	}

}
