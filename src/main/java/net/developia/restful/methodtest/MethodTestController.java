package net.developia.restful.methodtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest")
public class MethodTestController {
	
	private static Logger logger = LoggerFactory.getLogger(MethodTestController.class);
	
	@GetMapping("/")
	public String getAction() {
		return "get action 수행중";
	}
	
	@PostMapping("/")
	public String postAction() {
		return "post action 수행중";
	}
	
	@PutMapping("/")
	public String putAction() {
		return "put action 수행중";
	}
	@DeleteMapping("/")
	public String deleteAction() {
		return "delete action 수행중";
	}

}
