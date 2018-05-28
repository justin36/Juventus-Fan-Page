package global.sesoc.test6.mapper;

import java.util.ArrayList;

import global.sesoc.test6.vo.Reply;

public interface ReplyMapper {

	int insert(Reply r);
	
	Reply readOne(int replynum);
	
	ArrayList<Reply> rList(int boardnum);
	
	void update(Reply r);
	
	void delete(int replynum);
}
