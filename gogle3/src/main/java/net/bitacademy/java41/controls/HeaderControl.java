package net.bitacademy.java41.controls;

import javax.servlet.http.HttpSession;

import net.bitacademy.java41.services.MemberService;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeaderControl {
	@Autowired MemberService memberService;
	
	@RequestMapping("/header")
	public String execute(
			HttpSession session, Model model) throws Exception {
		Member member = (Member) session.getAttribute("member");
		session.setAttribute("member",memberService.getMember(member.getEmail()));
		return "/header.jsp";
	}
}







