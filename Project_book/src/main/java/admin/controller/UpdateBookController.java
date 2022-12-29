package admin.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import admin.model.BookBean;
import admin.model.BookDao;
import admin.model.GenreBean;
import admin.model.GenreDao;

@Controller
public class UpdateBookController {

	public final String command = "updateBook.ad";
	public String getPage = "updateBookForm";
	public String gotoPage = "redirect:/bookList.ad";
	
	@Autowired
	private GenreDao gdao;
	
	@Autowired
	private BookDao bdao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String bookupdate(@RequestParam("book_no") String book_no,
						Model model,HttpServletRequest request) {
		
		//no에 해당하는 book가져오기
		BookBean book = bdao.selectBookbyno(book_no);
		model.addAttribute("book",book);
		
		//장르 불러오기
		List<GenreBean> lists = gdao.getGenreCate();
		model.addAttribute("glists",lists);
		
		String fullPath = request.getContextPath()+"/resources/book_images";
		model.addAttribute("fullPath",fullPath);
		
		return getPage;
	}
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public String update(@ModelAttribute("book") @Valid BookBean book,
							BindingResult result,
							Model model,
							HttpServletRequest request,HttpSession session,
							HttpServletResponse response) {
		
		if(result.hasErrors()) {
			
			//장르 불러오기
			List<GenreBean> lists = gdao.getGenreCate();
			model.addAttribute("glists",lists);
			
			model.addAttribute("book",book);
			
			return getPage;
		}
		
		MultipartFile multi = book.getUpload();
		
		//이미지 파일 업로드 할 위치 설정
		String uploadPath = servletContext.getRealPath("/resources/book_images");
		System.out.println("uploadPath : "+uploadPath);
				
		File file = new File(uploadPath + "/" + multi.getOriginalFilename());
				
		try {
		//파일 업로드
			multi.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer;
		try {
			writer = response.getWriter();
			writer.println("<script>");
			writer.println("alert('성공적으로 수정하였습니다.');");
			writer.println("</script>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		int cnt = bdao.updateBook(book);
		
		
		return gotoPage;
	}
}
