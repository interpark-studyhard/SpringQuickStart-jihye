/**
 * 
 */
package com.interpark.sts.polymorphism;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 최지혜
 */
public class SonySpeaker {
	public static final Logger LOGGER = LoggerFactory.getLogger(SonySpeaker.class);
	public SonySpeaker() {
		System.out.println("===== > SonySpeaker 객체 생성...");
	}
	
	public void volumeUp() {
		System.out.println("-- Sony speaker 소리 올림 .. ");
	}
	
	public void volumeDown() {
		System.out.println("-- Sony speaker 소리 내림 .. ");
	}
}
