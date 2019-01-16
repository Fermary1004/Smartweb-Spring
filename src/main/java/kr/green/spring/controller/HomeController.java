package kr.green.spring.controller;

import java.util.Locale;

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
	public String homeGet(Locale locale, Model model) {
					
		model.addAttribute("serverTime", "서버시간" );
		System.out.println(accountService.getAccount("firststep"));
		return "home";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost(String name) {
		/* jsp에서 넘어온 데이터의 name과 일치시키는 것에 주의  */
		System.out.println("jsp에서 받아온 값 : " + name);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signupGet(Boolean fail, Model model) {
		if (fail == null) {
			fail = false;
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
