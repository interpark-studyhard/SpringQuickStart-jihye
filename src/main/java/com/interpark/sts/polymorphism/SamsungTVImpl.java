/**
 * 
 */
package com.interpark.sts.polymorphism;

import com.interpark.sts.polymorphism.ifs.Speaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 최지혜
 */
public class SamsungTVImpl implements TV {
	public static final Logger LOGGER = LoggerFactory.getLogger(SamsungTVImpl.class);
			
	private Speaker speaker;
//	private SonySpeaker sonySpeaker;
	private int price;

	public SamsungTVImpl() {
		LOGGER.info("==== > SamsungTV 객체 생성. ");
	}

	public SamsungTVImpl(Speaker speaker) {
		LOGGER.info("=== > samsungTV (2) 객체 생성.");
		this.speaker = speaker;
	}

	public SamsungTVImpl(Speaker speaker, int price) {
		LOGGER.info(" === > SamsungTV (3) 객체 생성 .. .");
		this.speaker = speaker;
		this.price = price;
	}
	
	/* (non-Javadoc)
	 * @see com.interpark.sts.polymorphism.TV#powerOn()
	 */
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		LOGGER.info("SamsungTV --- 전원 켠다. (가격 : "+ price +")");
	}

	/* (non-Javadoc)
	 * @see com.interpark.sts.polymorphism.TV#powerOff()
	 */
	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		LOGGER.info("SamsungTV --- 전원 끈다.");
	}

	/* (non-Javadoc)
	 * @see com.interpark.sts.polymorphism.TV#volumeUp()
	 */
	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
//		LOGGER.info("SamsungTV --- 소리 올린다.");
//		sonySpeaker = new SonySpeaker();
		speaker.volumeUp();
	}

	/* (non-Javadoc)
	 * @see com.interpark.sts.polymorphism.TV#volumeDown()
	 */
	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
//		LOGGER.info("SamsungTV --- 소리 내린다.");
//		sonySpeaker = new SonySpeaker();
		speaker.volumeDown();
	}

	public void initMethod() {
		LOGGER.info(" 객체 초기화 작업 처리 ... ");
	}
	
	public void destroyMethod() {
		LOGGER.info(" 객체 삭제 전에 처리할 로직 정리 . . ");
	}
	
}
