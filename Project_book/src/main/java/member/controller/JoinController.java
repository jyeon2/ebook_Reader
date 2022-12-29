package member.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class JoinController {

	private final String command = "join.me";
	private final String getPage = "join";
	private final String gotoPage = "redirect:/login.me";
	
	@Autowired
	private MemberDao mdao;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String join() {
		
		return getPage;
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public String join1(@ModelAttribute("member") @Valid MemberBean member,
			   			BindingResult result, HttpServletResponse response) {
		
		if(result.hasErrors()) {
			return getPage;
		}
		
		mdao.insertMember(member);
		
		return gotoPage;
		
	}
}
