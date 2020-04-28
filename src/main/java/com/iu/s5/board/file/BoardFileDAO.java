package com.iu.s5.board.file;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardFileDAO {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.iu.s5.board.file.BoardFileDAO.";
	
	//fileInsert
	public int fileInsert(BoardFileVO boardFileVO) throws Exception {
		return sqlSession.insert(NAMESPACE+"fileInsert", boardFileVO);
	}
	
	
	//fileSelect
	public BoardFileVO fileSelect(BoardFileVO boardFileVO)throws Exception{
		return sqlSession.selectOne(NAMESPACE+"fileSelect",boardFileVO);
	}

	public int fileDelete(BoardFileVO boardFileVO)throws Exception{
		return sqlSession.delete(NAMESPACE+"fileDelete", boardFileVO);
	}
	
	public List<BoardFileVO> fileList(long num)throws Exception{
		return sqlSession.selectList(NAMESPACE+"fileList",num);
	}
	
	public int fileDeleteAll(long num)throws Exception{
		return sqlSession.delete(NAMESPACE+"fileDeleteAll", num);
	}
}
