package global.sesoc.test6.mapper;

import java.util.ArrayList;

import global.sesoc.test6.vo.Board;

public interface BoardMapper {

	ArrayList<Board> bList();
	
	int insert(Board b);
	
	Board readOne(int boardnum);
	
	void hits(int boardnum);
	
	void update(Board b);
	
	void delete(int boardnum);
	
}
