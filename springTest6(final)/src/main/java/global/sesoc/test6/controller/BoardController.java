package global.sesoc.test6.controller;

import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import global.sesoc.test6.dao.BoardDAO;
import global.sesoc.test6.dao.ReplyDAO;
import global.sesoc.test6.util.FileService;
import global.sesoc.test6.vo.Board;
import global.sesoc.test6.vo.Reply;

@Controller
@RequestMapping("board")
public class BoardController {
	
	// C:\boardfile (WINDOWS)에 저장됨
	private final String UPLOAD_PATH = "/boardfile";
	
	@Autowired
	BoardDAO boardDAO;
	
	@Autowired
	ReplyDAO replyDAO;
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) {
		
		ArrayList<Board> bList = boardDAO.bList();
		model.addAttribute("bList", bList);
		
		return "board/list";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String writeForm() {
		
		return "board/writeForm";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String writeResult(MultipartFile upload, Board b, HttpSession session, Model model) {
		
		if (upload.isEmpty() == false) {
			// 파일을 스토리지에 저장
			String savedfile = FileService.saveFile(upload, UPLOAD_PATH);
			
			// board 객체에 실체 파일면과 저장된 파일명을 보존
			b.setOriginalfile(upload.getOriginalFilename());
			b.setSavedfile(savedfile);
		}
		
		String loginId = (String)session.getAttribute("loginId");
		b.setId(loginId);
		
		boardDAO.insert(b);
	
		return "redirect: ./list";
	}
	
	@RequestMapping(value = "read", method = RequestMethod.GET)
	public String readOne(int boardnum, Model model) {
	
		boardDAO.hits(boardnum);
		Board b = boardDAO.readOne(boardnum);
		
		model.addAttribute("b", b);
		
		ArrayList<Reply> rList = replyDAO.rList(boardnum);
		
		model.addAttribute("rList", rList);
		model.addAttribute("b.id", b.getId());

		return "board/writeResult"; 
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String editForm(Model model, int boardnum) {

		model.addAttribute("boardnum", boardnum);
		
		return "board/editForm";
	}
	
	@RequestMapping(value = "edit", method = RequestMethod.POST)
	public String editResult(Board b, int boardnum, HttpSession session) {
	
		String loginId = (String)session.getAttribute("loginId");
		
		b.setId(loginId);
		b.setBoardnum(b.getBoardnum());
		
		System.out.println(b);
		boardDAO.update(b);
		
		return "redirect:./list";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete(int boardnum) {
		
		boardDAO.delete(boardnum);
		
		return "redirect:./list";
	}
	
	@RequestMapping(value = "download", method = RequestMethod.GET)
	public void download(int boardnum, HttpServletResponse response) {
		
		// boardnum에 해당하는 게시글 VO 취득
		Board b = boardDAO.readOne(boardnum);
		
		// response에 header 설정
		String originalfile = b.getOriginalfile();
		
		try {
			response.setHeader("Content-Disposition", "attackment;filename="
						+ URLEncoder.encode(originalfile, "UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String fullpath = UPLOAD_PATH + "/" + b.getSavedfile();
		
		FileInputStream fis = null;
		ServletOutputStream sos = null;
		
		try {
			fis = new FileInputStream(fullpath);
			sos = response.getOutputStream();

			// 파일 복사		
			FileCopyUtils.copy(fis, sos);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if (sos != null) {
				try {
					sos.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}	
	}
}
