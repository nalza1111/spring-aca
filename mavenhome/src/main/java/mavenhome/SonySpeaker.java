package mavenhome;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
public class SonySpeaker implements Speaker {

	@Override
	public void volumnup() {
		System.out.println("sonySpeaker Volumn up");
	}

}
