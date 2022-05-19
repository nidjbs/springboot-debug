package com.xiaojukeji.springboot.demo.beans;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author huayuanlin on 2022/5/18
 */
@Component
public class FactoryBeanTest implements FactoryBean<FactoryBeanObj> {

	// // getBean(FactoryBeanObj.class);先通过get bean name 找到对应的factoryBean的name 然后再getBean(fatory bean name) 再getObject，当然第二次调用就直接从缓存中拿了
	@Override
	public FactoryBeanObj getObject() throws Exception {
		System.out.println("FactoryBeanTest#getObject()");
		return new FactoryBeanObj();
	}

	@Override
	public Class<?> getObjectType() {
		return FactoryBeanObj.class;
	}
}