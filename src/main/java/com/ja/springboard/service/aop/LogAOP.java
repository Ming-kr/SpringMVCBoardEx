package com.ja.springboard.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class LogAOP {

	@Pointcut("execution(* com.ja.springboard.service.*Impl.*(..))")
	//@Pointcut("execution(* com.ja.springboard..*.*(..))")
	public void serviceAroundPointcut() {}
	
	@Around("serviceAroundPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) 
			throws Throwable {
		
		System.out.println("========start:" + pjp.getSignature().getName() + "========");
		Object o = pjp.proceed();
		System.out.println("========end:" + pjp.getSignature().getName() + "========");
		
		return o;
	}
}









