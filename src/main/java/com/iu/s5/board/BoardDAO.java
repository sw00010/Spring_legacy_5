package com.iu.s5.board;

import java.util.List;

public interface BoardDAO {
	//멤버변수 상수
	//추상메서드
	//public abstract 
	//생략해도 자동으로 만들어짐
	
	//List
	public List<BoardVO> boardList() throws Exception;
	
	//select
	public BoardVO boardSelect() throws Exception;
	
	//insert
	public int boardWrite(BoardVO boardVO)throws Exception;

	//delete
	public int boardDelete(long num)throws Exception;
	
	//update
	public int boardUpdate(BoardVO boardVO) throws Exception;
	
	//hit update
	public int hitUpdate(BoardVO boardVO)throws Exception;
}
