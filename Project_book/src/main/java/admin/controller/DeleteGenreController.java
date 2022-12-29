package admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import admin.model.GenreDao;

@Controller
public class DeleteGenreController {

	public final String command = "deleteGenre.ad";
	public String gotoPage = "redirect:/genreList.ad";
	
	@Autowired
	private GenreDao gdao;
	
	@RequestMapping(command)
	public String delete(@RequestParam("gno") String gno,
						Model model) {
		
		gdao.deleteGenre(gno);
		
		return gotoPage;
	}
}
