package admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import admin.model.BookBean;
import admin.model.BookDao;


@Controller
public class BookListController {

	public final String command="bookList.ad";
	public String gotoPage="bookList";
	
	@Autowired
	private BookDao bdao;
	
	@RequestMapping(command)
	public String list(Model model) {
		
		List<BookBean> lists = bdao.getAllBook();
		model.addAttribute("blists",lists);
		
		return gotoPage;
	}
}
