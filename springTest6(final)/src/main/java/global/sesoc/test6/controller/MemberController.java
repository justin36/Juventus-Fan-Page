package global.sesoc.test6.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import global.sesoc.test6.dao.MemberDAO;
import global.sesoc.test6.vo.Member;

@Controller
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	MemberDAO dao;
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String joinForm() {
		
		return "member/joinForm";
	}
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String joinResult(Member m) {
		
		int a = dao.insert(m);
		System.out.println(a);
		
		return "redirect: ../";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String editForm(HttpSession session, Member m, Model model) {
		
		String loginId = (String) session.getAttribute("loginId");
		
		m.setId(loginId);
		String id = m.getId();
		
		Member member = dao.readOne(id);
		
		model.addAttribute("m", member);
		
		return "member/editForm";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editResult(Member m) {
		
		dao.update(m);
		
		return "redirect: ../";
	}
	
	@RequestMapping(value = "idCheck", method = RequestMethod.GET)
	public String idCheckForm() {
		
		return "member/idCheck";
	}
	
	@RequestMapping(value = "idCheck", method = RequestMethod.POST)
	public String idCheckResult(String id, Model model) {
		
		Member m = dao.readOne(id);
		
		if (m == null) {
			model.addAttribute("idCheck", "°¡´É");
		} else {
			model.addAttribute("idCheck", "");
		}
		model.addAttribute("id", id);
			
		return "member/idCheck";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(HttpSession session) {
		
		String loginId = (String)session.getAttribute("loginId");
		
		dao.delete(loginId);
		session.invalidate();
		
		return "redirect:../";
	}
}
