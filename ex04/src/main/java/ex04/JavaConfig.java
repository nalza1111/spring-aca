package ex04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration//설정파일임을 알림(실행시 읽힘)
public class JavaConfig {
	@Bean
	@Scope("singleton")
	//@Scope("prototype")
	//@Scope("request")
	//@Scope("session")
	//@Lazy 모든 빈을 생성하지 않음(서버구동오래걸림)
	public BoardService boardservice() {
		return new BoardServiceImpl();
	}
}
