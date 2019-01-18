package kr.green.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/bbs")
public class BoardController {

	// 컨트롤러에 매핑을 하면, 컨트롤러 아래의 모든 메소드의 메핑 정보 앞에 컨트롤러의 매핑 값이 붙는다
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listGet(String login, Model model) {
		model.addAttribute("login", login);
		return "bbs/list";
	}
}
