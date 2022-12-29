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
			System.out.println("�������� ���� ȸ��");
			try {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter writer = response.getWriter();
				writer.println("<script>");
				writer.println("alert('�������� ���� ȸ���Դϴ�.\\n�̸��ϰ� ��й�ȣ�� �ٽ� �Է����ּ���.');");
				writer.println("location.href='login.me'");
				writer.println("</script>");
				
				writer.flush(); //script�±� �ۼ��Ѱ� ��������
			} catch (IOException e) {
				e.printStackTrace();
			}
			return getPage;
		}
		else {
			System.out.println("������ ȸ��");
			MemberBean loginMember = mdao.selectMemberOne(member);

			session.setAttribute("memberInfo", loginMember);
			
			if(loginMember.getEmail().equals("admin@a")) { //������
				application.setAttribute("admin",loginMember);
				return "redirect:/home.ad";
			} 
			else { 
				
				return gotoPage;
			}
		}
	}
	
}