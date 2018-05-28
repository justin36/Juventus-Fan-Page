package global.sesoc.test6.dao;

import java.util.HashMap;



import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.test6.mapper.MemberMapper;
import global.sesoc.test6.vo.Member;

@Repository
public class MemberDAO implements MemberMapper{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int insert(Member m) {

		int result = 0;
		try {
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			result = mapper.insert(m);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public Member login(HashMap<String, String> map) {

		Member member = null;
		try {
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			member = mapper.login(map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return member;
	}

	@Override
	public Member readOne(String id) {

		Member m = null;
		try {
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			m = mapper.readOne(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return m;
	}
	
	@Override
	public void update(Member m) {
		
		try {
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			mapper.update(m);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void delete(String id) {
		
		try {
			MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
			mapper.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
}
