package com.iu.s5.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.s5.board.BoardDAO;
import com.iu.s5.board.BoardVO;

@Repository
public class NoticeDAO implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE="com.iu.s5.notice.NoticeDAO.";
	
	@Override
	public List<BoardVO> boardList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardVO boardSelect() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int boardWrite(BoardVO boardVO) throws Exception {
		return sqlSession.insert(NAMESPACE+"boardWrite", boardVO);
		
	}
	
	@Override
	public int boardDelete(long num) throws Exception {
		return sqlSession.delete(NAMESPACE+"boardDelete", num);
	}
	
	

}
