/**
 * 
 */
package com.interpark.sts.polymorphism;

/**
 * @author 최지혜
 *
 */
public class LgTVImpl implements TV {

	/* (non-Javadoc)
	 * @see com.interpark.sts.polymorphism.TV#powerOn()
	 */
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("LgTv --- 전원 켠다.");
	}

	/* (non-Javadoc)
	 * @see com.interpark.sts.polymorphism.TV#powerOff()
	 */
	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("LgTv --- 전원 끈다.");
	}

	/* (non-Javadoc)
	 * @see com.interpark.sts.polymorphism.TV#volumeUp()
	 */
	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("LgTv --- 소리 올린다.");
	}

	/* (non-Javadoc)
	 * @see com.interpark.sts.polymorphism.TV#volumeDown()
	 */
	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("LgTv --- 소리 내린다.");
	}

}
