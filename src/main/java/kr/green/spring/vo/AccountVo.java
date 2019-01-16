package kr.green.spring.vo;

public class AccountVo {
	// 맴버변수의 이름은 테이블의 속성 이름과 일치시켜주는 것이 구별하기 좋다
	private String id;
	private String pw;
	private String email;
	
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
	
	@Override
	public String toString() {
		return "AccountVo [id=" + id + ", pw=" + pw + ", email=" + email + "]";
	}
	// toString은 오브젝트를 문자열로 반환할때 자동으로 호출되지만
	// 기본적으로 object class에서 getClass().getName()+'@'+Integer.getHashCode();로 지정되어있어서
	// 용도에 맞게 오버라이드 해서 사용해야한다.
}
