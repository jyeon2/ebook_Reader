package admin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import admin.model.GenreBean;
import admin.model.GenreDao;

@Controller
public class UpdateGenreController {

	public final String command = "updateGenre.ad";
	public String getPage = "updateGenreForm";
	public String gotoPage = "redirect:/genreList.ad";
	
	@Autowired
	private GenreDao gdao;
	
	@RequestMapping(value=command,method=RequestMethod.GET)
	public String update(@RequestParam("gno") String gno,
						Model model) {
		
		GenreBean genre = gdao.selectByGno(gno);
		model.addAttribute("genre",genre);
		return getPage;
		
	}
	
	@RequestMapping(value=command,method=RequestMethod.POST)
	public String update1(@ModelAttribute("genre") @Valid GenreBean genre,
						BindingResult result, Model model) {
		
		if(result.hasErrors()) {
			
			return getPage;
		}
		
		gdao.updateGenre(genre);
		
		return gotoPage;
	}
}
