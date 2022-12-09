package mavenhome;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class App {
//	public static void main(String[] args) {
//		GenericXmlApplicationContext ctx =
//				new GenericXmlApplicationContext("classpath:applicationContext.xml");
//		Tv tv = ctx.getBean(Tv.class);
//		tv.on();
//	}
	//@Test
	public void test() {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		Tv tv = ctx.getBean(SamsungTv.class);
		tv.on();
	}
	@Autowired Tv tv;
	@Test
	public void test2() {
		tv.on();
	}
}
