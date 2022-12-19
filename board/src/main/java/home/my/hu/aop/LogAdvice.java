package home.my.hu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;
@Aspect
@Component
@Log4j
public class LogAdvice {
	@Pointcut("execution(* home.my.hu..*Impl.*(..))")
	public void allpointcut() {}//java설정
	
	
	@Before("allpointcut()")
	public void logBefore() {
		log.info("#########################[before]");
		System.out.println("?????????????????");
	}
//	
//	@Around("allpointcut()")
//	public void logtime(ProceedingJoinPoint pjt) throws Throwable {
//		log.info("#########################[around before]");
//		long start = System.currentTimeMillis();
//		Object result = pjt.proceed();
//		log.info("#########################result : " + result);
//		long end = System.currentTimeMillis();
//		log.info("#########################TIME : " + (end-start));
//		log.info("#########################[around after]");
//		System.out.println("?????????????????22@@@@@@@@@@");
//	}
}
