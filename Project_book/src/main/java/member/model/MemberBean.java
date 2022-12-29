package member.model;

import org.hibernate.validator.constraints.NotBlank;

public class MemberBean {
	private int mno;
	
	@NotBlank(message="�̸����� �Է��ϼ���")
	private String email;
	
	@NotBlank(message="��й�ȣ�� �Է��ϼ���")
	private String password;
	
	@NotBlank(message="�̸��� �Է��ϼ���")
	private String name;
	
	@NotBlank(message="����ó�� �Է��ϼ���")
	private String phone;
	
	@NotBlank(message="��ȣ�帣�� �����ϼ���")
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
