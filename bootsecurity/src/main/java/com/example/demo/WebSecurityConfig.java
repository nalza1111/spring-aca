package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 일반스프링의 xml설정들을...이거 하나로 
public class WebSecurityConfig {

	@Bean//필터가 여러개로 열결되어있어서 체인..필터체인 여기다 시큐리티체인하나 더 얹음
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http  //권한체크
			.authorizeHttpRequests((requests) -> requests
					//이건 모두 허용
					//밑에는2.5버전..
				//.requestMatchers("/", "/home").permitAll()
				.antMatchers("/", "/home").permitAll()
				.antMatchers("/admin").hasAnyRole("ADMIN")//이건 어드만롤을 가진사람만 접근허용..hasAnyRole말고도 메소드 많음
				.anyRequest().authenticated()
			)//이것도 모두허용
			.formLogin((form) -> form
				.loginPage("/login")//엔터후.누르면 설정들 볼 수 있음
				.passwordParameter("pw")//패스워드 파라미터바꿈
				.usernameParameter("userId")//원래유저네임인데 id로바꾸겠음..(로그인창도 바꾸기)
				.loginProcessingUrl("/signIn")//url
				.permitAll()//여기서 위로 세줄 없어도 자동으로 로그인 페이지 만들어줌? 안되는디
			)//시큐리티가 알아서 로그인 로그아웃처리해줌
			.logout((logout) -> logout.permitAll());
		//403 포비든 권한없음
		return http.build();
	}
	@Bean//java기반의 빈설정<bean id=xxx클래스이름 class=xxx리턴값)
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("1234")
				.roles("USER")
				.build();
		//InMemory상에서 유저아이디와 패스워드관리
		//DB연동안했기 때문에 메모리상으로 관리하겠음
		
		//ADMIN계정추가
		UserDetails admin =
				 User.withDefaultPasswordEncoder()
					.username("admin")
					.password("1234")
					.roles("ADMIN")
					.build();
		return new InMemoryUserDetailsManager(user, admin);
	}
}
