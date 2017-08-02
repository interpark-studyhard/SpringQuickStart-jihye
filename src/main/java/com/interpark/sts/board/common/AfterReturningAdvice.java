package com.interpark.sts.board.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.interpark.sts.board.vo.UserVO;

/**
 * @author 최지혜
 */
@Service
@Aspect
public class AfterReturningAdvice {
	private static final Logger LOGGER = LoggerFactory.getLogger(AfterReturningAdvice.class);
	
//	@Pointcut("execution(* com.interpark.sts.board..*ServiceImpl.get*(..))")
//	public void getPointCut(){}
	
	@AfterReturning(pointcut="PointCutCommon.getPointCut()", returning="returnObj")
	public void afterLog(JoinPoint jp, Object returnObj) {
		if( returnObj instanceof UserVO ) {
			UserVO user = (UserVO) returnObj;
			if("admin".equalsIgnoreCase(user.getRole())) {
				LOGGER.info(" {} 로그인 (관리자) .", user.getName());
			}
		}
		
		LOGGER.info("\n [ afterReturning afterLog ] \n method : {}(), return value : {} ", jp.getSignature().getName(), returnObj.toString());
	}
}
