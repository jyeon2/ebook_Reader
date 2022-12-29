package admin.controller;

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import admin.model.BookBean;
import admin.model.BookDao;

@Controller
public class DeleteBookController {

	public final String command = "deleteBook.ad";
	public String gotoPage="redirect:/bookList.ad";
	
	@Autowired
	private BookDao bdao;
	
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping(command)
	public String delete(@RequestParam("book_no") String book_no,
						Model model,HttpServletRequest request) {
		System.out.println("delete(book_no) :"+book_no);
		
		//이미지 파일을 지우려는 경로
		String deletePath = servletContext.getRealPath("/resources/book_images");
		//이미지 파일 이름을 가지고 오기
		BookBean book = bdao.selectBookbyno(book_no);
		//이미지 파일 까지 삭제하기
		File delFile = new File(deletePath,book.getPhoto());
		delFile.delete();
		
		bdao.deleteBook(book_no);
		
		return gotoPage;
	}
}
