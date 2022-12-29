package member.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController {

	private final String command = "logout.me";
	private final String gotoPage = "redirect:/home.me";
	
	@Autowired
	private ServletContext application;
	
	@RequestMapping(command)
	public String logout(HttpSession session) {
		session.invalidate(); //memberInfo 세션 삭제
		application.removeAttribute("admin");
		return gotoPage;
	}
	
}
