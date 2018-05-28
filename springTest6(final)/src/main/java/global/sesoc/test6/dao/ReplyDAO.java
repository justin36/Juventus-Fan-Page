package global.sesoc.test6.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.test6.mapper.ReplyMapper;
import global.sesoc.test6.vo.Reply;

@Repository
public class ReplyDAO implements ReplyMapper {

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insert(Reply r) {
		
		int result = 0;
		try {
			ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
			result = mapper.insert(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Reply readOne(int replynum) {

		Reply r = null;
		try {
			ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
			r = mapper.readOne(replynum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return r;
	}

	@Override
	public ArrayList<Reply> rList(int boardnum) {

		ArrayList<Reply> rList = null;
		try {
			ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
			rList = mapper.rList(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rList;
	}

	@Override
	public void update(Reply r) {
		
		try {
			ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
			mapper.update(r);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int replynum) {

		try {
			ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
			mapper.delete(replynum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
