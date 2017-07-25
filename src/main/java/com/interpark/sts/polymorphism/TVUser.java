/**
 * 
 */
package com.interpark.sts.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * @author 최지혜
 */
public class TVUser {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		SamsungTV tv = new SamsungTV();
//		LgTV tv = new LgTV();
		/*
		TV tv = new SamsungTVImpl();
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		*/
		
		// 1. Spring container를 구동
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 필요한 객체를 요청(Lookup) 한다.
		TV tv = (TV) factory.getBean("tv");
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		// 3. Spring container 를 종료
		factory.close();
	}

}
