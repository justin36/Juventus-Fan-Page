package global.sesoc.test6.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.test6.mapper.BulletinMapper;
import global.sesoc.test6.vo.Bulletin;

@Repository
public class BulletinDAO{

	@Autowired
	SqlSession sqlSession;
	
	public int insert(Bulletin b) {
		
		int result = 0;
		try {
			BulletinMapper mapper = sqlSession.getMapper(BulletinMapper.class);
			result = mapper.insert(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	public ArrayList<Bulletin> bulletinList() {
		
		ArrayList<Bulletin> bList = null;
		try {
			BulletinMapper mapper = sqlSession.getMapper(BulletinMapper.class);
			bList = mapper.bulletinList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bList;
	}

	public Bulletin readOne(int bulletinnum) {
		
		Bulletin b = null;
		try {
			BulletinMapper mapper = sqlSession.getMapper(BulletinMapper.class);
			b = mapper.readOne(bulletinnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return b;
	}
	
	
}
