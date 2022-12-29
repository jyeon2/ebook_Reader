package admin.model;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

public class BookBean {

	private int book_no;
	
	@NotBlank(message="�帣�� �����ϼ���")
	private String gname;
	
	@NotBlank(message="å �̸��� �Է��ϼ���")
	private String bname;
	
	@NotBlank(message="�۰��� �Է��ϼ���")
	private String author;
	
	@NotBlank(message="���ǻ縦 �Է��ϼ���")
	private String publisher;
	
	@NotBlank(message="�������� �����ϼ���")
	private String bookdate;
	
	@NotBlank(message="������ �����ϼ���")
	private String photo;
	
	@NotBlank(message="������1�� �Է��ϼ���")
	private String con1;
	
	@NotBlank(message="������2�� �Է��ϼ���")
	private String con2;
	
	private MultipartFile upload;
	
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
		this.photo = upload.getOriginalFilename();
	}
	
	/*
	 * public BookBean(int book_no, String gname, String bname, String author,
	 * String publisher, String price, String bookdate, String photo, String con1,
	 * String con2) { super(); this.book_no = book_no; this.gname = gname;
	 * this.bname = bname; this.author = author; this.publisher = publisher;
	 * this.price = price; this.bookdate = bookdate; this.photo = photo; this.con1 =
	 * con1; this.con2 = con2; }
	 */
	
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getBookdate() {
		return bookdate;
	}
	public void setBookdate(String bookdate) {
		this.bookdate = bookdate;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getCon1() {
		return con1;
	}
	public void setCon1(String con1) {
		this.con1 = con1;
	}
	public String getCon2() {
		return con2;
	}
	public void setCon2(String con2) {
		this.con2 = con2;
	}
	
	
}
