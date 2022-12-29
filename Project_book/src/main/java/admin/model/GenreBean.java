package admin.model;

import org.hibernate.validator.constraints.NotBlank;

public class GenreBean {

	private int gno;
	
	@NotBlank(message="장르 이름을 입력하세요")
	private String name;
	
	public int getGno() {
		return gno;
	}
	public void setGno(int gno) {
		this.gno = gno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
