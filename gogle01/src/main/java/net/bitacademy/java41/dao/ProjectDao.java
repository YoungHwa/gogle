package net.bitacademy.java41.dao;

import java.util.List;
import java.util.Map;

import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;

public interface ProjectDao {
	 List<Project> list() throws Exception; 
	 String leaderByProject(int no) throws Exception;
	 Project get(int no) throws Exception;
	 List<Member> memberByProject(int no) throws Exception ;
	 List<MemberProject> listByMember(String email) throws Exception ;
	 int add(Project project) throws Exception;
	 int addProjectMember(Map<String,Object> paramMap) throws Exception;
	 void update(Project project) throws Exception;
	 void deleteProjectMember(int no) throws Exception;
	 void deleteProjectTask(int no)throws Exception;
	 void delete(int no) throws Exception;
	 
}
