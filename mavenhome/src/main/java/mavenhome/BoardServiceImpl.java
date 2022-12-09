package mavenhome;

import lombok.Data;
import lombok.extern.log4j.Log4j;

@Data
@Log4j
public class BoardServiceImpl implements BoardService{

	@Override
	public int boardInsert() {
		log.info("등록완료");
		return 0;
	}

}
