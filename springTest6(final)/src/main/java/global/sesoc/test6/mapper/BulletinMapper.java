package global.sesoc.test6.mapper;

import java.util.ArrayList;

import global.sesoc.test6.vo.Bulletin;

public interface BulletinMapper {

	int insert(Bulletin b);
	
	ArrayList<Bulletin> bulletinList();
	
	Bulletin readOne(int bulletinnum);
}
