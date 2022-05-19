package com.xiaojukeji.springboot.demo.beans;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author huayuanlin on 2022/5/17
 */
public class MyApplicationListener implements ApplicationListener {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
//		System.out.println("MyApplicationListener#onApplicationEvent" + event);
	}
}