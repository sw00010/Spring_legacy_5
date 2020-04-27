package com.iu.s5.board.file;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardFileService {
	
	@Autowired
	private BoardFileDAO boardFileDAO;
	
	public BoardFileVO fileSelect(BoardFileVO boardFileVO) throws Exception{
		return boardFileDAO.fileSelect(boardFileVO);
	}
	
	public int fileDelete(long fileNum)throws Exception{
		return boardFileDAO.fileDelete(fileNum);
	}

}
