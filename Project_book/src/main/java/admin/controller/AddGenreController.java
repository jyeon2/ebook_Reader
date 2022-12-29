package admin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import admin.model.GenreBean;
import admin.model.GenreDao;

@Controller
public class AddGenreController {

	private final String command = "addGenre.ad";
	private String getPage = "addGenreForm";
	public String gotoPage = "redirect:/genreList.ad";
	
	@Autowired
	private GenreDao gdao;
	

	@RequestMapping(value=command,method=RequestMethod.GET)
	public String addgenre() {
		return getPage;

	}

	@RequestMapping(value=command,method=RequestMethod.POST)
	public String addgenre1(@ModelAttribute("genre") @Valid GenreBean genre,
							BindingResult result) {

		if(result.hasErrors()) {

			return getPage;
		}

		gdao.insertGenre(genre);

		return gotoPage;
	}
}
