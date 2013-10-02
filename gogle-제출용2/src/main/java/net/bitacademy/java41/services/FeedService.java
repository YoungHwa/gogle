package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.vo.Feed;


public interface FeedService {
	
	
	 String addFeed(String content,String email, int projectNo) throws Exception ;
	 List<Feed> getFeedList(int projectNo) throws Exception ;
	 void deleteFeed(int fno) throws Exception ;
//	 List<MemberProject> getMyProjects(String email) throws Exception;
//	 List<Member> memberByProject(int no) throws Exception;
//	 void updateProject(Project project) throws Exception ;
//	 int addProjectMember(String email, int projectNo, int level) throws Exception ;
}













