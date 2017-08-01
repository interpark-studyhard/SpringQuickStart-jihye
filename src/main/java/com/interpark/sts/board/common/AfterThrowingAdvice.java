/**
 * 
 */
package com.interpark.sts.board.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 최지혜
 */
public class AfterThrowingAdvice {
	private static final Logger LOGGER = LoggerFactory.getLogger(AfterThrowingAdvice.class);
	
	public void exceptionLog() {
		LOGGER.info("[ 예외 처리 ] 비지니스 로직 수행 중 예외 발생 ...");
	}
}
