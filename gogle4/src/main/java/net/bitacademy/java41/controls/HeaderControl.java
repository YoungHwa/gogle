package net.bitacademy.java41.controls;

import javax.servlet.http.HttpSession;

import net.bitacademy.java41.services.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeaderControl {
	@Autowired MemberService memberService;
	
	@RequestMapping("/header")
	public String execute(
			HttpSession session, String email) throws Exception {
		session.setAttribute("headerInfo", 
				memberService.getMember(email));
		return "/header.jsp";
	}
}
