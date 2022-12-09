package mavenhome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Log4j
@Component
public class SamsungTv implements Tv{
//
	@Setter(onMethod_ = {@Autowired})
	Speaker speaker;
//	
//	public void setSpeaker(Speaker speaker) {
//		this.speaker = speaker;
//	}
//	
//	public SamsungTv() {}
//	
//	public SamsungTv(Speaker speaker) {
//		super();
//		this.speaker = speaker;
//	}
//	
	@Override
	public void on() {
		System.out.println("on");
		speaker.volumnup();
	}

}
