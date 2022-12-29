package admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import admin.model.GenreBean;
import admin.model.GenreDao;

@Controller
public class GenreListController {

	public final String command="genreList.ad";
	public String gotoPage="genreList";
	
	@Autowired
	private GenreDao gdao;
	
	@RequestMapping(command)
	public String list(Model model) {
		
		List<GenreBean> lists = gdao.getAllGenre();
		model.addAttribute("lists",lists);
		
		return gotoPage;
	}
}
