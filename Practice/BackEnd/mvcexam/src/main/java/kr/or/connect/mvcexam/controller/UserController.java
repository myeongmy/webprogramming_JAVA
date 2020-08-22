package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.connect.mvcexam.dto.User;

@Controller
public class UserController {
	@GetMapping(path = "/userform")
	public String userform() {
		return "userForm";
	}
	
	@PostMapping(path = "/regist")
	public String regist(@ModelAttribute User user) {   //한 번에 user 객체에 요청받은 정보를 받아줄 수도 있다.
		
		return "regist";	
	}
}
