package member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	private final String command = "home.me";
	private final String getPage = "home";
	
	@RequestMapping(command)
	public String home() {
		return getPage;
		
	}
}
