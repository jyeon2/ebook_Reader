package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class FindidController {

	private final String command = "findid.me";
	private final String getPage = "findid";
	private String gotoPage = "redirect:/login.me";

	@Autowired
	private MemberDao mdao;

	@RequestMapping(value=command, method=RequestMethod.GET)
	public String findid() {
		return getPage;

	}

	@RequestMapping(value=command, method=RequestMethod.POST)
	public String findid(@ModelAttribute("member") MemberBean member
			,HttpServletResponse response) throws IOException {
		

		System.out.println("findid");

		MemberBean mb = mdao.findId(member);
		if(mb==null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>");
			writer.println("alert('가입하지 않은 회원입니다.');");
			writer.println("</script>");

			writer.flush();
			
			return getPage;
		}
		else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			writer.println("<script>");
			writer.println("alert('"+mb.getEmail()+"입니다.');");
			writer.println("location.href='login.me'");
			writer.println("</script>");

			writer.flush();
			
			return gotoPage;
		}
		

	}
	
}
