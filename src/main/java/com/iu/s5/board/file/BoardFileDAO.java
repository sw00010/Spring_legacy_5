package com.iu.s5.board.file;

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


}