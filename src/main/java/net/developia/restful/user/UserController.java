package net.developia.restful.user;

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

@Controller 
@RequestMapping("user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	//자동주입
	@Autowired	
	private UserService userService;
	
	// 이쪽으로 보낼 매핑값 (로그인창)
	@GetMapping("/")
	public String login() {
		return "user/login";
	}

	// 로그인할때
	@PostMapping("/")// 아이디와 비밀번호 값이 넘어옴
	public String login(@ModelAttribute UserVO userVO, Model model, HttpSession session) {	// 클래스로 담아서 넘김 (@한꺼번에 받을때는 @ModelAttribute)
		logger.info(userVO.toString());
		try {
			UserVO userInfo = userService.getUser(userVO);
			logger.info(userInfo.toString());
			
			session.setAttribute("userInfo", userInfo);
			return "redirect:../board/";	// restful로 갔다가 board로 이동 
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("msg",e.getMessage());
			model.addAttribute("url","./");	// 현재 URL
			return "result";
		}
		
	}
	// 로그아웃
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		UserVO userInfo = (UserVO) session.getAttribute("userInfo");
		session.invalidate();
		ModelAndView mav = new ModelAndView("result");
		mav.addObject("msg",userInfo.getUsr_name() + "(" + userInfo.getUsr_id() + ")님이 로그아웃");
		mav.addObject("url","./");
		return mav;
	}
	
}
