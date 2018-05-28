package global.sesoc.test6.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.test6.dao.BulletinDAO;
import global.sesoc.test6.vo.Bulletin;

@Controller
@RequestMapping("bulletin")
public class BulletinController {

	@Autowired
	BulletinDAO dao;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {
		
		ArrayList<Bulletin> bulletinList = dao.bulletinList();
		
		model.addAttribute("bulletinList", bulletinList);
		
		return "bulletin/list";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String writeForm() {
		
		return "bulletin/writeForm";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String writeResult(Bulletin b, HttpSession session, Model model) {
		
		String loginId = (String)session.getAttribute("loginId");
		
		b.setId(loginId);	
		dao.insert(b);
				
		return "redirect: ../bulletin/list";
	}
	
	@RequestMapping(value = "read", method = RequestMethod.GET)
	public String readOne(int bulletinnum, Model model) {
	
		Bulletin b = dao.readOne(bulletinnum);
		
		model.addAttribute("b", b);
		
		return "bulletin/read";
	}
}
