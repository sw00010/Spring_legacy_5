package com.iu.s5.board;

import java.util.List;

import com.iu.s5.util.Pager;

public interface BoardService {
	
	//List
	public List<BoardVO> boardList(Pager pager)throws Exception;
	
	//Select
	public BoardVO boardSelect(long num) throws Exception;
	
	//Insert
	public int boardWrite(BoardVO boardVO) throws Exception;
	
	//update
	public int boardUpdate(BoardVO boardVO)throws Exception;
	
	//delete
	public int boardDelete(long num)throws Exception;
	

}
