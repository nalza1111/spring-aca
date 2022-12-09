package mavenhome;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaConfig {
	@Bean
	@Scope("Singleton")
	public BoardService boardService() {
		return new BoardServiceImpl();
	}
}
