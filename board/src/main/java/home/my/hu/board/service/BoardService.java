package home.my.hu.board.service;

import java.util.List;
import java.util.Map;

import home.my.hu.common.Paging;


public interface BoardService {
	//글조회
	public BoardVO getBoard(String bno);//
	//글수정
	public int updateBoard(BoardVO vo);//
	//글작성
	public int insertBoard(BoardVO vo);//
	//글삭제
	public int deleteBoard(BoardVO vo);//
	//글전체 + 검색
	public List<Map<String, Object>> getBoardAll(BoardVO vo, Paging paging);
	//글전체 + 검색 카운트
	public int count(BoardVO vo);
}
