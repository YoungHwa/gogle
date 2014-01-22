package net.bitacademy.java41.controls.feed;

import javax.servlet.http.HttpSession;

import net.bitacademy.java41.services.FeedService;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/feed")
public class FeedControl {
	@Autowired FeedService feedService;

	@RequestMapping("/main")
	public String main(int projectNo,Model model) throws Exception {
		model.addAttribute(projectNo);
		return "feed/main";
	}
	
	@RequestMapping("/addForm")
	public String addForm() {
		return "feed/add";
	}
	
	@RequestMapping("/add")
	public String add(String content,
						HttpSession session,
						 int projectNo) throws Exception {
		
		Member member = (Member)session.getAttribute("member");
		String email  = member.getEmail();
		
		
		
		if(feedService.addFeed(content,email,projectNo).equals("success")){
			return "feed/main";
		}else {
			return "feed/fail";
		}
		
		
	}
	
	@RequestMapping("/list")
	public String list(int projectNo,Model model) throws Exception {
		model.addAttribute("list", feedService.getFeedList(projectNo));
		return "feed/list";
	}
	
//	@RequestMapping("/delete")
//	public String delete(int no) throws Exception {
//		projectService.removeProject(no);
//		return "redirect:list.do";
//	}
}













