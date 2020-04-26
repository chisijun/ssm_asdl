/**  
 * @Title: ApplicationContextUtil.java
 * @Package org.csun.nc.utils
 * @Description: TODO
 * @author chisj chisj@foxmail.com
 * @date 2017年10月23日
 */
package org.study.asdl.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * ClassName: ApplicationContextUtil 
 * @Description: 注解加载工具类
 * @author chisj chisj@foxmail.com
 * @date 2017年10月23日
 */
public class ApplicationContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		ApplicationContextUtil.applicationContext = applicationContext;
	}

	/**
	 * @Description: 根据名称查询Bean对象
	 * @param @name Bean名称
	 * @param @return Bean对象
	 * @return Object  
	 * @throws
	 * @author chisj chisj@foxmail.com
	 * @date 2017年11月7日
	 */
	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}
	
	/**
	 * @Description: 通过类类型加载Bean实体
	 * @param @c 类名
	 * @param @return 实体对象
	 * @return Object 实体对象
	 * @throws
	 * @author chisj chisj@foxmail.com
	 * @date 2017年11月7日
	 */
	@SuppressWarnings("unchecked")
	public static Object getBeanByClass(Class c) {
		return applicationContext.getBean(c);
	}
	
}
