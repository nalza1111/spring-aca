package com.company.app.aop;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect //java설정
@Component //java설정
@Log4j
public class LogAdvice {
	@Pointcut("execution(* com.company.app..*Impl.*(..))") //java설정
	public void allpointcut() {}//java설정
	
	@Before("allpointcut()")//java설정
	public void logBefore() { //실행전에 
		log.info("[before]");
	}
	
	@Around("allpointcut()") //모두 서비스 실행 전후 공통적으로 해야할 일 있으면 
	public void logtime(ProceedingJoinPoint pjt) throws Throwable { //실행시간찍기
		log.info("[around before]");
		long start = System.currentTimeMillis();
		Object result = pjt.proceed(); //서비스 호출
		log.info("RESULT : " + result);
		long end = System.currentTimeMillis();
		log.info("TIME : " + (end-start) );
		log.info("[around after]");
	}
}
