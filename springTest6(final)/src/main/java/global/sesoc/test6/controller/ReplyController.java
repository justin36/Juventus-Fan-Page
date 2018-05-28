package global.sesoc.test6.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.test6.dao.BoardDAO;
import global.sesoc.test6.dao.ReplyDAO;
import global.sesoc.test6.vo.Board;
import global.sesoc.test6.vo.Reply;

@Controller
@RequestMapping("reply")
public class ReplyController {
	
	@Autowired
	ReplyDAO replyDAO;
	
	@Autowired
	BoardDAO boardDAO;
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(Reply r, int boardnum, HttpSession session) {
		
		Board b = boardDAO.readOne(boardnum);
		
		String loginId = (String) session.getAttribute("loginId");
		
		r.setId(loginId);
		
		replyDAO.insert(r);
		
		return "redirect:../board/read?boardnum=" + boardnum;
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String editForm(int boardnum, int replynum, Model model) {
		
		model.addAttribute("boardnum", boardnum);
		model.addAttribute("replynum", replynum);
		
		return "reply/editForm";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editResult(int boardnum, Reply r, HttpSession session) {
				
		String loginId = (String) session.getAttribute("loginId");
		r.setId(loginId);
		
		replyDAO.update(r);
		
		return "redirect:../board/read?boardnum=" + boardnum;
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int boardnum, int replynum) {
		
		replyDAO.delete(replynum);
		
		return "redirect: ../board/read?boardnum=" + boardnum;
	}
}
