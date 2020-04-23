package com.iu.s5.board.file;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class BoardFileDAOTest {
	@Autowired
	private BoardFileDAO boardFileDAO;

	@Test
	public void fileInsertTest() throws Exception {
		BoardFileVO boardFileVO = new BoardFileVO();
		
		boardFileVO.setNum(1);
		boardFileVO.setBoard(1);
		boardFileVO.setFileName("fileName");
		boardFileVO.setOriName("OriName");
		int result = boardFileDAO.fileInsert(boardFileVO);
		assertEquals(1, result);
	}
}
