package member.model;

import org.hibernate.validator.constraints.NotBlank;

public class MemberBean {
	private int mno;
	
	@NotBlank(message="이메일을 입력하세요")
	private String email;
	
	@NotBlank(message="비밀번호를 입력하세요")
	private String password;
	
	@NotBlank(message="이름을 입력하세요")
	private String name;
	
	@NotBlank(message="연락처를 입력하세요")
	private String phone;
	
	@NotBlank(message="선호장르를 선택하세요")
	private String prefer;
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPrefer() {
		return prefer;
	}
	public void setPrefer(String prefer) {
		this.prefer = prefer;
	}
	
	
}
