package kr.green.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.spring.service.AccountService;
import kr.green.spring.vo.AccountVo;

@Controller
public class HomeController {
	
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet(Model model) {
		model.addAttribute("login", "fail");
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost(String id, String pw, Model model) {
		
		if (accountService.login(id, pw)) {
			model.addAttribute("login", id);
			return "redirect:/bbs/list";
			// bbs로 가는 매핑정보는 보드컨트롤러로 넘어가게 된다(보드 컨트롤러 참조)
		} else {
			model.addAttribute("login", "fail");
			return "redirect:/";
		}
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupGet(Boolean fail, Model model) {
		if (fail == null) {
			fail = false;
			// 처음에 fail을 지정하지 않고 /signup으로 바로 접속할때
			// ?fail=값에 아무값도 들어있지 않기 때문에 에러가 날 수 있으므로 방지한다
			// 이때문에 처음에 null값이 있을 수 있도록 boolean을 하단에서 wrapping해서 넘겨준다
		}
		model.addAttribute("fail", fail);
		return "account/signup";
	}
	// int -> Integer, double -> Double, boolean -> Boolean을 wrapper class로 말하며
	// 원시 대이타에 null값을 허용하게 해준다
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signupPost(AccountVo accountVo, Model model) {
		
		if (accountService.signup(accountVo)) {
			return "redirect:/";
		} else {
			model.addAttribute("fail", true);
			return "redirect:/signup";
		}
		// 리다이렉트이므로 jsp로 가는게 아니라 위의 signupGet를 거친다
		// 그쪽으로 데이타를 넘겨준후에 다시한번 더 처리
	}

}
