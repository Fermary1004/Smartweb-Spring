package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.AccountDao;
import kr.green.spring.vo.AccountVo;

@Service
public class AccountServiceImp implements AccountService {
	
	// Autowired는 객체생성을 자동으로 해주는 옵션
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public AccountVo getAccount(String id) {
		return accountDao.getAccount(id);
	}

	@Override
	public boolean signup(AccountVo accountVo) {
		String idCheck = accountVo.getId();
		AccountVo valCheck = accountDao.getAccount(idCheck);
		
		if (valCheck == null) {
			String encodedPassword = passwordEncoder.encode(accountVo.getPw());
			accountVo.setPw(encodedPassword);
			accountVo.setAuthority("user");
			accountDao.insertAccount(accountVo);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public AccountVo login(String id, String pw) {
		AccountVo user = accountDao.getAccount(id); 
		if (user == null) {
			return null;
		} else if (passwordEncoder.matches(pw, user.getPw()) == false) {
			return null;
		} else return user;
	}

}
