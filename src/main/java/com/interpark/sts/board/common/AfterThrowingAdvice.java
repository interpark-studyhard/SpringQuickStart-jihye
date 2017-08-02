/**
 * 
 */
package com.interpark.sts.board.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
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
public class AfterThrowingAdvice {
	private static final Logger LOGGER = LoggerFactory.getLogger(AfterThrowingAdvice.class);
	
	@Pointcut("execution(* com.interpark.sts.board..*ServiceImpl.*(..))")
	public void allPointCut(){}
	
	@AfterThrowing(pointcut="allPointCut()", throwing="exceptionObj")
	public void exceptionLog(JoinPoint jp, Exception exceptionObj) {
		LOGGER.info("\n [ 예외 처리 ] an exception occurs at [ {}() ] . \n Exception message : {} ", jp.getSignature().getName(), exceptionObj.getMessage());
		
		if(exceptionObj instanceof IllegalArgumentException ) {
			LOGGER.error("부적절한 값이 입력되었습니다.");
		} else if (exceptionObj instanceof NumberFormatException ) {
			LOGGER.error("숫자 형식의 값이 아닙니다.");
		} else if (exceptionObj instanceof Exception ) {
			LOGGER.error("문제가 발생했습니다. ");
		}
	}
}
