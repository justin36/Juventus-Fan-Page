package global.sesoc.test6.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.test6.dao.MemberDAO;
import global.sesoc.test6.vo.Member;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	MemberDAO dao;
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String loginResult(Member m, Model model, HttpSession session) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", m.getId());
		map.put("password", m.getPassword());
		
		Member member = dao.login(map);
		
		if (member != null) {
			session.setAttribute("loginId", member.getId());
		} else {
			model.addAttribute("errorMessage", "로그인 실패");
		}
		
		return "redirect:../";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:../";
	}
	
}
