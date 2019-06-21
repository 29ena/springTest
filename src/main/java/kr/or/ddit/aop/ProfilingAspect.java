package kr.or.ddit.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ProfilingAspect {
	private static final Logger logger = LoggerFactory.getLogger(ProfilingAspect.class);
	
	@Pointcut("execution(* kr.or.ddit..service.*.*(..))")
	public void dummy() {}
	
	@Around("dummy()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		// business logic 실행 전
		long startTime = System.currentTimeMillis();
		logger.debug("Profiling Aspect around method before : {}", startTime);
		
		Object[] methodArgs = joinPoint.getArgs();	// 메소드 인자를 받는다.
		Object returnObj = joinPoint.proceed(methodArgs);	// 메서드 실행. 반환값이 있을 경우 받아준다.
		
		// business logic 실행 후
		long endTime = System.currentTimeMillis();
		logger.debug("Profiling Aspect around method after : {}", endTime);
		
		// business 실행 전 - business logic 실행 후 
		logger.debug("method name : {}", endTime-startTime + "ms");
		
		return returnObj;
	}
}
