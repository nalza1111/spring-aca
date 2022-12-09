package ex04;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {
//	public static void main(String[] args) {
//		//System.out.println("빌드 테스트");
//		//컨테이너(applicationContext=Ioc 컨테이너)에
//		//빈(싱글톤 새로운 객체를 만들지 않고 한번 만들어 계속 사용)으로 등록
//		GenericXmlApplicationContext ctx =//xml기반의 
//			new GenericXmlApplicationContext("classpath:applicationContext.xml");
//		//가져와 사용
//		Tv tv = ctx.getBean(Tv.class);
//		tv.on();
//	}
	//@Test //pom.xml에 junit넣기
	public void text() {
		GenericXmlApplicationContext ctx = 
			new GenericXmlApplicationContext("classpath:applicationContext.xml");
		Tv tv = ctx.getBean(SamsungTv.class);
		tv.on();
	}
	@Test
	public void text2() {
		GenericXmlApplicationContext ctx = 
			new GenericXmlApplicationContext("classpath:applicationContext.xml");
		Tv tv = ctx.getBean(Tv.class);
		tv.on();
	}
}
