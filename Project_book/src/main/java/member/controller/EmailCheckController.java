package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import member.model.MemberBean;
import member.model.MemberDao;

@Controller
public class EmailCheckController {
	
private final String command = "emailCheck.me";
	
	@Autowired
	private MemberDao mdao;
	
	@RequestMapping(value=command)
	public void emailcheck(@RequestParam("useremail") String useremail,
							HttpServletResponse response) {
		//dao
		MemberBean mb = mdao.searchEmail(useremail);
		
		PrintWriter writer=null;
		
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("mb:"+mb);
		if(mb==null) {
			writer.print("사용가능");
		}
		else {
			writer.print("사용불가능");
		}
		
		writer.flush();
		
	}
	
	
}
