package org.study.asdl.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.study.asdl.common.JsonResult;

/**
 * @author puyijun
 * @date 2017.12.18
 * @desc 异常处理切面
 */
@Aspect
@Component
public class ExceptionAspect {
	@Around("within(org.study.asdl.controller.*Controller)")
	public Object process(ProceedingJoinPoint target) {
		
		try{
			Object o = target.proceed();
			return o;
		} catch(Throwable e){
			System.out.println("runtime:");
			e.printStackTrace();
			return new JsonResult(e);
		}
	}
}
