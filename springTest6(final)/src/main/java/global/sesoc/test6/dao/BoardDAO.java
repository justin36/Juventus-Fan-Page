package global.sesoc.test6.dao;

import java.util.ArrayList;


import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.test6.mapper.BoardMapper;
import global.sesoc.test6.vo.Board;

@Repository
public class BoardDAO implements BoardMapper{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public ArrayList<Board> bList() {
		ArrayList<Board> bList = new ArrayList<Board>();
		
		try {
			BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			bList = mapper.bList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bList;
	}
	
	@Override
	public int insert(Board b) {
		int result = 0;
		
		try {
			BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			result = mapper.insert(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Board readOne(int boardnum) {
		Board b = null;
		
		try {
			BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			b = mapper.readOne(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return b;
	}

	@Override
	public void hits(int boardnum) {
		
		try {
			BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			mapper.hits(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Board b) {
		
		try {
			BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			mapper.update(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int boardnum) {
		
		try {
			BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			mapper.delete(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
