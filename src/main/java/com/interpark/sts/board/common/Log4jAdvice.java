/**
 * 
 */
package com.interpark.sts.board.common;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 최지혜
 */
public class Log4jAdvice {
	private static final Logger LOGGER = LoggerFactory.getLogger(Log4jAdvice.class);
	
	public void printLogging(JoinPoint jp) {
		LOGGER.info(" [ 공통 로그 - Log4j ] 비지니스 로직 수행 전 동작 ... ");
	}

}
