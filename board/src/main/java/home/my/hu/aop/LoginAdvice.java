package home.my.hu.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
@Aspect
@Log4j
public class LoginAdvice {
	@After("LogAdvice.allpointcut()")//다른 클래스의 포인터컷 참조 after(에러상관없이 무조건실행)
	public void logAfter() {
		log.info("[After!!!!]");
	}
}
