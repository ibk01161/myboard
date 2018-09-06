package net.developia.restful.jqueryui;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.developia.restful.user.ItemVO;
import net.developia.restful.user.UserService;

@Controller
@RequestMapping("jqueryui")
public class AutoCompleteController {
	private static Logger logger = LoggerFactory.getLogger(AutoCompleteController.class);
	
	@Autowired
	private UserService userService;
	
	@GetMapping("autocomplete/")
	public String autocomplete() {
		return "jqueryui/autocomplete";
	}
	
	@GetMapping("autocomplete_action/")
	@ResponseBody
	public List<ItemVO> autocomplete(@RequestParam String term) {
		logger.info("term : " + term);
		List<ItemVO> list = userService.getWords(term);
		return list;
	}

}
