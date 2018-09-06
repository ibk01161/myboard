package net.developia.restful.board;

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
@RequestMapping("board/{boa_no}/{pg}/{art_no}")
public class ArticleDetailController {
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleDetailController.class);
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public String detail(@PathVariable int boa_no, @PathVariable long pg, @PathVariable long art_no, Model model) {
		logger.info("게시판 번호 : " + boa_no + " 페이지 : " + pg + " 게시물 : " + art_no);
		
		try {
			boardService.updateReadcnt(art_no);
			ArticleVO articleVO = boardService.getArticle(art_no);
			articleVO.setArt_content(articleVO.getArt_content().replace("\n", "<br/>"));
			model.addAttribute("articleVO",articleVO);
			return "board/detail";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg",e.getMessage());
			model.addAttribute("url","../");		// 상위 디렉토리로 이동 (게시물리스트)
			return "result";
		}	
	}
	
	@GetMapping("/update")
	public String update(@PathVariable long art_no, Model model) {	
		
		try {
			boardService.updateReadcnt(art_no);
			ArticleVO articleVO = boardService.getArticle(art_no);
			model.addAttribute("articleVO",articleVO);
			return "board/update";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg",e.getMessage());
			model.addAttribute("url","../");		// 상위 디렉토리로 이동 (게시물리스트)
			return "result";
			
		}
	}
	
	@PostMapping("/update")
	public ModelAndView update(@ModelAttribute ArticleVO articleVO, HttpSession session) {
		articleVO.setUserVO((UserVO)session.getAttribute("userInfo"));
		try {
			boardService.updateArticle(articleVO);
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg",articleVO.getArt_no() + "번 수정");
			mav.addObject("url","./");	
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg",e.getMessage());
			mav.addObject("url","javascript:history.back();");
			return mav;
		}
	}
	
	@GetMapping("/delete")
	public ModelAndView delete(@ModelAttribute ArticleVO articleVO, HttpSession session) {
		articleVO.setUserVO((UserVO)session.getAttribute("userInfo"));
		
		try {
			boardService.deleteArticle(articleVO);
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg",articleVO.getArt_no() + "번 삭제");
			mav.addObject("url","../");
			return mav;
		} catch (Exception e) {
			e.printStackTrace();
			ModelAndView mav = new ModelAndView("result");
			mav.addObject("msg",e.getMessage());
			mav.addObject("url","javascript:history.back();");
			return mav;
		}
		
	}

}
