/**
 * 
 */
package com.interpark.sts.board.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author 최지혜
 */
@Aspect
public class PointCutCommon {
	
	@Pointcut("execution(* com.interpark.sts.board..*ServiceImpl.*(..))")
	public void allPointCut(){}
	
	@Pointcut("execution(* com.interpark.sts.board..*ServiceImpl.get*(..))")
	public void getPointCut(){}
}
