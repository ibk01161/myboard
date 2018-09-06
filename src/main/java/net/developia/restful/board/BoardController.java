package net.developia.restful.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.developia.restful.user.UserVO;

@Controller
@RequestMapping("board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public String list(Model model) {
		try {
			List<BoardVO> list = boardService.getBoardList();
			model.addAttribute("list",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/board_list";	// 보드 디렉토리에 보드리스트로
	}
	
	@GetMapping("insert")	// 게시판 입력 폼
	public String insert() {
		return "board/board_insert";
	}
	
	@PostMapping("insert")
	public ModelAndView insert(@ModelAttribute BoardVO boardVO, HttpSession session) {
		boardVO.setUserVO((UserVO)session.getAttribute("userInfo"));	// 세션에서 로그인값들을 가져옴
		try {
			boardService.insertBoard(boardVO);
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg",boardVO.getBoa_name() + "게시판이 생성");
			mav.addObject("url","./");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg",boardVO.getBoa_name() + "생성 실패!!");
			mav.addObject("url","./");
			return mav;
		}
	}

}
