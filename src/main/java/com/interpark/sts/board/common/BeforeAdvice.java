/**
 * 
 */
package com.interpark.sts.board.common;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author 최지혜
 */
@Service
@Aspect
public class BeforeAdvice {
	private static final Logger LOGGER = LoggerFactory.getLogger(BeforeAdvice.class);
	
//	@Pointcut("execution(* com.interpark.sts.board..*ServiceImpl.*(..))")
//	public void allPointCut() {}
	
	@Before("PointCutCommon.allPointCut()")
	public void beforeLog(JoinPoint jp) {
		LOGGER.info(" [사전 처리] 비즈니스 로직 수행 전 동작. method : [{}()], argument 정보 : {} ", jp.getSignature().getName(), Arrays.toString(jp.getArgs()));
	}
}
