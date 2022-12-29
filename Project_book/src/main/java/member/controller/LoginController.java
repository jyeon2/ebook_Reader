package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class LoginController {
	private final String command = "login.me";
	private final String getPage = "login";
	private final String gotoPage = "redirect:/home.me";
	
	@Autowired
	private MemberDao mdao;
	
	@Autowired
	private ServletContext application;
	
	@RequestMapping(value=command, method=RequestMethod.GET)
	public String login() {
		
		
		return getPage;
		
	}
	
	@RequestMapping(value=command, method=RequestMethod.POST)
	public String login1(@ModelAttribute("member") MemberBean member,
						HttpServletResponse response,
						HttpSession session, Model model) {
		
		boolean check = mdao.checkEmailPassword(member);
		if(check == false) {
			System.out.println("가입하지 않은 회원");
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>");
				writer.println("alert('가입하지 않은 회원입니다.\\n이메일과 비밀번호를 다시 입력해주세요.');");
				writer.println("location.href='login.me'");
				writer.println("</script>");
				
				writer.flush(); //script태그 작성한거 내보내기
			} catch (IOException e) {
				e.printStackTrace();
			}
			return getPage;
		}
		else {
			System.out.println("가입한 회원");
			MemberBean loginMember = mdao.selectMemberOne(member);

			session.setAttribute("memberInfo", loginMember);
			
			if(loginMember.getEmail().equals("admin@a")) { //관리자
				application.setAttribute("admin",loginMember);
				return "redirect:/home.ad";
			} 
			else { 
				
				return gotoPage;
			}
		}
	}
	
}