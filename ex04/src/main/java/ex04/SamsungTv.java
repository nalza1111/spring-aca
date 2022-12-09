package ex04;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Data
@AllArgsConstructor
@NoArgsConstructor //all생성자+no생성자 꼭 같이 쓰기
@Log4j
@Component //<bean id="">하고 같음
public class SamsungTv implements Tv {

//Setter
//	@Autowired//DI(의존성)주입
//	Speaker speaker;
//이렇게도 가능
	@Setter(onMethod_ = {@Autowired})
	Speaker speaker;
	
	
// 롬복Data를 넣었기에 밑에 다 주석
	
//	public SamsungTv() {}
//	
//	public SamsungTv(Speaker speaker) {
//		super();
//		this.speaker = speaker;
//	}

//	public void setSpeaker(Speaker speaker) {
//		this.speaker = speaker;
//		//property name의 speaker와 setSpeaker 의 speaker가 매핑됨
//	}
//	@Override
//	public void on() {
//		System.out.println("on");
//		//티비를 쓰려면 스피커가 필요함(의존성)
//		speaker.volumnup();
//	}
	
	
	//Logger log = LogManager.getLogger(SamsungTv.class);
	//어노테이션으로 로그객체 쓰겠음
	@Override
	public void on() {
		log.info("log info samaung tv on");
		speaker.volumnup();
	}
	
}
