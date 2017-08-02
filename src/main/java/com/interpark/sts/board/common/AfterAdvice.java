/**
 * 
 */
package com.interpark.sts.board.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author 최지혜
 */
@Service
@Aspect
public class AfterAdvice {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AfterAdvice.class);
	
//	@Pointcut("execution(* com.interpark.sts.board..*ServiceImpl.*(..))")
//	public void allPointCut(){}
	
	@After("PointCutCommon.allPointCut()")
	public void finallyLog() {
		LOGGER.info("\n[AfterAdvice finallyLog] 비즈니스 로직 수행 후 무조건 동작.");
	}
}
