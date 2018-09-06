package net.developia.restful.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.developia.restful.user.UserVO;

@Controller
@RequestMapping("/board/{boa_no}/{pg}/{art_no}/{cpg}")
public class CommentController {

	private static Logger logger = LoggerFactory.getLogger(CommentController.class);
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	@ResponseBody
	public List<CommentVO> comment_list(@ModelAttribute CommentVO commentVO) {
		try {
			return boardService.getCommentList(commentVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	
	@PostMapping("/")
	@ResponseBody
	public List<CommentVO> comment_insert(
			@ModelAttribute CommentVO commentVO, HttpServletRequest request, HttpSession session) {
		commentVO.setCom_ip(request.getRemoteAddr());
		commentVO.setUserVO((UserVO) session.getAttribute("userInfo"));
		logger.info("comment_insert() 메소드 수행");
		logger.info(commentVO.toString());
		try {
			boardService.insertComment(commentVO);
			return boardService.getCommentList(commentVO);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping("/{com_no}")
	@ResponseBody
	public List<CommentVO> comment_update(@ModelAttribute CommentVO commentVO, HttpServletRequest request, HttpSession session) throws Exception {
		
		commentVO.setCom_ip(request.getRemoteAddr());
		commentVO.setUserVO((UserVO) session.getAttribute("userInfo"));
		
		logger.info("comment_update() 메소드 수행");
		logger.info(commentVO.toString());
		
			boardService.updateComment(commentVO);
			return boardService.getCommentList(commentVO);
	}
	
	@DeleteMapping("/{com_no}")
	@ResponseBody
	public List<CommentVO> comment_delete(@PathVariable long com_no, @ModelAttribute CommentVO commentVO, HttpServletRequest request, HttpSession session) throws Exception{
		
		commentVO.setCom_ip(request.getRemoteAddr());
		commentVO.setUserVO((UserVO) session.getAttribute("userInfo"));
		
		logger.info("comment_delete() 메소드 수행");
		logger.info(commentVO.toString());
		
			boardService.deleteComment(commentVO);
			return boardService.getCommentList(commentVO);
	
	}
	

}
