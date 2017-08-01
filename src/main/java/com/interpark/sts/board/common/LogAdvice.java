/**
 * 
 */
package com.interpark.sts.board.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 최지혜
 */
public class LogAdvice {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogAdvice.class);
	
	public void printLog() {
		LOGGER.info("[공통 로그] 비지니스 로직 수행 전 동작");
	}
	
}
