package kr.green.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.spring.dao.AccountDao;
import kr.green.spring.vo.AccountVo;

@Service
public class AccountServiceImp implements AccountService {
	
	// Autowired는 객체생성을 자동으로 해주는 옵션
	@Autowired
	private AccountDao accountDao;

	@Override
	public AccountVo getAccount(String id) {
		return accountDao.getAccount(id);
	}

	@Override
	public boolean signup(AccountVo accountVo) {
		String idCheck = accountVo.getId();
		AccountVo valCheck = accountDao.getAccount(idCheck);
		
		if (valCheck == null) {
			accountVo.setAuthority("user");
			accountDao.insertAccount(accountVo);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean login(String id, String pw) {
		
		AccountVo checkAccount = accountDao.getAccount(id); 
		if (checkAccount == null) {
			return false;
		} else if (checkAccount.getPw().equals(id) == false) {
			// 문자열 비교는 equals를 사용한다 ==를 사용하면 다르게 나온다
			return false;
		} else return true;
	}

}
