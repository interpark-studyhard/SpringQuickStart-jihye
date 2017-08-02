/**
 * 
 */
package com.interpark.sts.board.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author 최지혜
 */
//TODO aspect = pointcut+advice 이므로 aspect 설정된 객체에는 반드시 둘다 있어야 함.
//@Service
//@Aspect
public class LogAdvice {

	private static final Logger LOGGER = LoggerFactory.getLogger(LogAdvice.class);
	
//	@Pointcut("execution(* com.interpark.sts.board..*Impl.*(..))")
	public void allPointCut(){}
	
	//pointcut
//	@Pointcut("execution(* com.interpark.sts.board..*Impl.get*(..))")
	public void getPointCut(){}
	
	//advice
//	@Before("allPointCut()")
	public void printLog() {
		LOGGER.info("[공통 로그] 비지니스 로직 수행 전 동작");
	}
	
}
