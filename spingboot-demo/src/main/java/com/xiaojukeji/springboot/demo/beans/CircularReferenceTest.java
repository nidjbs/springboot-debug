package com.xiaojukeji.springboot.demo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

/**
 * @author huayuanlin on 2022/5/18
 */
@Component
public class CircularReferenceTest {

	@Autowired
	private FactoryBeanTest factoryBeanTest;


	public FactoryBeanTest getFactoryBeanTest() {
		return factoryBeanTest;
	}

	public void setFactoryBeanTest(FactoryBeanTest factoryBeanTest) {
		this.factoryBeanTest = factoryBeanTest;
	}

	public FactoryBeanObj getFactoryBeanObj() {
		return factoryBeanObj;
	}

	public void setFactoryBeanObj(FactoryBeanObj factoryBeanObj) {
		this.factoryBeanObj = factoryBeanObj;
	}

	@Autowired
	private FactoryBeanObj factoryBeanObj;


	@Component
	public static class A {

		@Autowired
		private B b;

		@Retryable
		public void test() {

		}

		public A () {
			System.out.println("CircularReferenceTest#A ----");
		}
	}

	@Component
	public static class B {

		@Autowired
		private A a;

		public B() {
			System.out.println("CircularReferenceTest#B ----");
		}

	}


}