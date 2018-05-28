package global.sesoc.test6.mapper;

import java.util.HashMap;

import global.sesoc.test6.vo.Member;

public interface MemberMapper {

	int insert(Member m);
	
	Member login(HashMap<String, String> map);
	
	Member readOne(String id);
	
	void update(Member m);
	
	void delete(String id);
	
}
