/**
 * 
 */
package com.interpark.sts.polymorphism;

/**
 * @author 최지혜
 */
public class BeanFactory {

	public Object getBean(String beanName) {
		if(beanName.equalsIgnoreCase("samsung")) {
			return new SamsungTV();
		} else if (beanName.equalsIgnoreCase("lg")) {
			return new LgTV();
		}
		return null;
	}
	
}
  