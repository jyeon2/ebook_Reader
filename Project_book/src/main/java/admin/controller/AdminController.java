package admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
	
	private final String command = "home.ad";
	private final String getPage = "admin_home";
	
	@RequestMapping(command)
	public String home() {
		return getPage;
		
	}
}
