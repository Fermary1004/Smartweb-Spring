package kr.green.spring.vo;

import java.sql.Date;

public class AccountVo {
	// 맴버 변수의 이름은 테이블의 콜론명과 일치시키는 것이 좋다
	private String id;
	private String pw;
	private String email;
	private String gender;
	private String authority;
	private Date registered_date;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public Date getRegistered_date() {
		return registered_date;
	}
	public void setRegistered_date(Date registered_date) {
		this.registered_date = registered_date;
	}
	@Override
	public String toString() {
		return "AccountVo [id=" + id + ", pw=" + pw + ", email=" + email + ", gender=" + gender + ", authority=" + authority
				+ ", registered_date=" + registered_date + "]";
	}
	// toString은 오브젝트를 문자열로 반환할때 자동으로 호출되지만
	// 기본적으로 object class에서 getClass().getName()+'@'+Integer.getHashCode();로 지정되어있어서
	// 용도에 맞게 오버라이드 해서 사용해야한다.
}
