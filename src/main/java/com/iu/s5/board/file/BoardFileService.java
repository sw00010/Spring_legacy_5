package com.iu.s5.board.file;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.s5.util.FileSaver;

@Service
public class BoardFileService {
	
	@Autowired
	private FileSaver fileSaver;
	
	@Autowired
	private ServletContext servletContext;
	
	@Autowired
	private BoardFileDAO boardFileDAO;
	
	public BoardFileVO fileSelect(BoardFileVO boardFileVO) throws Exception{
		return boardFileDAO.fileSelect(boardFileVO);
	}
	
	public int fileDelete(BoardFileVO boardFileVO)throws Exception{
		boardFileVO = boardFileDAO.fileSelect(boardFileVO);
		int result = boardFileDAO.fileDelete(boardFileVO);
		//1. HDD에 삭제 
		String board="uploadnotice";
		if(boardFileVO.getBoard()==2) {
			board="uploadQna";
		}
		String path = servletContext.getRealPath("/resources/"+board);
		fileSaver.deleteFile(boardFileVO.getFileName(), path);
		return result;
	}
	
	public List<BoardFileVO> fileList(long num)throws Exception{
		return boardFileDAO.fileList(num);
	}

}
