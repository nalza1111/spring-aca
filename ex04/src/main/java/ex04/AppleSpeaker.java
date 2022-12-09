package ex04;

import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Log4j
@Component
public class AppleSpeaker implements Speaker {

	@Override
	public void volumnup() {
		log.info("AppleSpeaker Volumn up");
	}

}
