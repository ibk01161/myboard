package net.developia.restful.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.developia.restful.user.UserVO;

@Controller
@RequestMapping("board/{boa_no}/{pg}")
public class ArticleController {
	private static final Logger logger = LoggerFactory.getLogger(ArticleController.class);
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public String list(@PathVariable int boa_no, Model model) {
		// 게시물 리스트 가져오기
		try {
			BoardVO boardVO = boardService.getBoard(boa_no);	// 어떤 게시판인지 나타냄
			
			List<ArticleVO> list = boardService.getArticleList(boa_no);
			model.addAttribute("boardVO",boardVO);
			model.addAttribute("list",list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "board/list";
	}
	
	@GetMapping("insert")
	public String insert() {
		return "board/insert";
	}
	
	@PostMapping("insert")
	public ModelAndView insert(@ModelAttribute ArticleVO articleVO, HttpSession session, HttpServletRequest request) {
		articleVO.setArt_ip(request.getRemoteAddr());
		articleVO.setUserVO((UserVO)session.getAttribute("userInfo"));
		logger.info(articleVO.toString());
		try {
			boardService.insertArticle(articleVO);
			return new ModelAndView("redirect:./");
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg", "입력 실패");
			mav.addObject("url", "javascript:history.back()");
			return mav;
		}
		
	}

}
