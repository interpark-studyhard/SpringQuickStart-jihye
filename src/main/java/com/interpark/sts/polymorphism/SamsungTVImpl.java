/**
 * 
 */
package com.interpark.sts.polymorphism;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 최지혜
 *
 */
public class SamsungTVImpl implements TV {
	public static final Logger LOGGER = LoggerFactory.getLogger(SamsungTVImpl.class);
			
	private SonySpeaker sonySpeaker;
	
	public SamsungTVImpl() {
		System.out.println("==== > SamsungTV 객체 생성. ");
	}
	
	/* (non-Javadoc)
	 * @see com.interpark.sts.polymorphism.TV#powerOn()
	 */
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("SamsungTV --- 전원 켠다.");
	}

	/* (non-Javadoc)
	 * @see com.interpark.sts.polymorphism.TV#powerOff()
	 */
	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("SamsungTV --- 전원 끈다.");
	}

	/* (non-Javadoc)
	 * @see com.interpark.sts.polymorphism.TV#volumeUp()
	 */
	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
//		System.out.println("SamsungTV --- 소리 올린다.");
		sonySpeaker = new SonySpeaker();
		sonySpeaker.volumeUp();
	}

	/* (non-Javadoc)
	 * @see com.interpark.sts.polymorphism.TV#volumeDown()
	 */
	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
//		System.out.println("SamsungTV --- 소리 내린다.");
		sonySpeaker = new SonySpeaker();
		sonySpeaker.volumeDown();
	}

	public void initMethod() {
		System.out.println(" 객체 초기화 작업 처리 ... ");
	}
	
	public void destroyMethod() {
		System.out.println(" 객체 삭제 전에 처리할 로직 정리 . . ");
	}
	
}
