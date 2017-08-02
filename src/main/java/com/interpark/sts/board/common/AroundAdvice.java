/**
 * 
 */
package com.interpark.sts.board.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

/**
 * @author 최지혜
 */
//@Service
//@Aspect
public class AroundAdvice {
	private static final Logger LOGGER = LoggerFactory.getLogger(AroundAdvice.class);
	
//	@Pointcut("execution(* com.interpark.sts.board..*ServiceImpl.*(..))")
//	public void allPointCut(){}
//	@Pointcut("execution(* com.interpark.sts.board..*DAOImpl.*(..))")
	public void allPointCut(){}
	
//	@Around("allPoijntCut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
//		LOGGER.info("[ AroundAdvice - BEFORE ] : 비지니스 메소드 수행 전에 처리할 내용..");
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object returnObj = pjp.proceed();
		stopWatch.start();
		LOGGER.info("[{}()] 수행에 걸린 시간 : {}(ms)초", pjp.getSignature().getName(), stopWatch.getTotalTimeMillis());
//		LOGGER.info("[ AroundAdvice - AFTER ] : 비지니스 메소드 수행 후에 처리할 내용..");
		return returnObj;
	}
}
