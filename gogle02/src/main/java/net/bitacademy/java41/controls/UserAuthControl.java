package net.bitacademy.java41.controls;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.bitacademy.java41.services.AuthService;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


@Controller
@SessionAttributes("member")
@RequestMapping("/auth")
public class UserAuthControl {
	@Autowired AuthService authService;

	@RequestMapping("/logout")
	public String logout(SessionStatus status) throws Exception {
		status.setComplete();
		return "redirect:loginForm.do";
	}
	
	@RequestMapping("/loginForm")
	public String form(
			@CookieValue(value="email", required=false) String email,
			Model model) {
		boolean isSaveId = false;
		if (email != null) {
			isSaveId = true;
		}
		
		model.addAttribute("email", email);
		model.addAttribute("isSaveId", isSaveId);
		
		return "auth/loginForm";
	}
	
	@RequestMapping("/login")
	public String login(
			String email,
			String password,
			String saveId,
			HttpServletResponse response,
			Model model,
			SessionStatus status
			) throws Exception {
		
		Member member = authService.getUserInfo(email, password);
		
		
		if(saveId != null) {
			Cookie cookie = new Cookie("email", email);
			cookie.setMaxAge(60); 
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("email", null);
			cookie.setMaxAge(0); 
			response.addCookie(cookie);
		}
		
		if (member != null) {
			model.addAttribute("member", member);
			return "redirect:../main.do";
			
		} else {
			status.setComplete();
			return "auth/loginFail";
		}
	}

}







