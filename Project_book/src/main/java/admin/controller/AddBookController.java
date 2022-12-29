package admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import admin.model.BookBean;
import admin.model.BookDao;
import admin.model.GenreBean;
import admin.model.GenreDao;

@Controller
public class AddBookController {

	public final String command="addBook.ad";
	public String getPage = "addBookForm";
	public String gotoPage = "redirect:/bookList.ad";
	
	@Autowired
	private GenreDao gdao;
	
	@Autowired
	private BookDao bdao;
	
	@Autowired
	ServletContext servletContext;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String addbook(Model model) {
		
		List<GenreBean> lists = gdao.getGenreCate();
		model.addAttribute("glists",lists);
		return getPage;
		
	}
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public String addbook1(@ModelAttribute("book") @Valid BookBean book,
					  BindingResult result,Model model,HttpSession session,
					  HttpServletRequest request) {
		
		if(result.hasErrors()) {
			
			List<GenreBean> lists = gdao.getGenreCate();
			model.addAttribute("glists",lists);
			
			model.addAttribute("book",book);
	        
	         return getPage;
		}
		
		MultipartFile multi = book.getUpload();
		
		/*
		 * //book DB에 넣기 BookBean bb = new
		 * BookBean(0,book.getGname(),book.getBname(),book.getAuthor(),
		 * book.getPublisher(),book.getPrice(),book.getBookdate(),book.getPhoto(),book.
		 * getCon1(),book.getCon2());
		 */
		
	      
		//이미지 파일 업로드 할 위치 설정
		String uploadPath = servletContext.getRealPath("/resources/book_images");
		System.out.println("uploadPath : "+uploadPath);
		System.out.println(multi.getOriginalFilename());
		
		File file = new File(uploadPath + "/" + multi.getOriginalFilename());
		
		try {
			//파일 업로드
			multi.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/*
		 * request.setAttribute("msg", "성공적으로 등록하였습니다"); request.setAttribute("url",
		 * "bookList.ad");
		 */
		//이미지 파일 명을 DB에 넣는 작업
		int cnt = bdao.insertBook(book);	
		
		return gotoPage;
	}
}
