/**
 * 
 */
package com.interpark.sts.board.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 최지혜
 */
public class BeforeAdvice {
	private static final Logger LOGGER = LoggerFactory.getLogger(BeforeAdvice.class);
	
	public void beforeLog() {
		LOGGER.info(" [사전 처리] 비즈니스 로직 수행 전 동작.. . ");
	}
}
