package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.annotation.Component;
import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.vo.Project;
import net.bitacademy.java41.vo.ProjectEx;
import net.bitacademy.java41.vo.ProjectMember;

@Component
public class ProjectService {
	ProjectDao projectDao;
	MemberDao memberDao;

	public ProjectService setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}
	public ProjectService setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}

	
	public List<ProjectEx> getMyProjects(String email) throws Exception {
		return projectDao.getUserProjectList(email);
	}

	public List<ProjectEx> getTotalProjectList() throws Exception {
		return projectDao.getProjectList();
	}
	
	public ProjectEx getProjectInfo(int no) throws Exception {
		return projectDao.getProjectInfol(no);
	}
	
	public List<ProjectMember> getProjectMemberList(int no) throws Exception {
		return memberDao.getProjectMemberList(no);
	}
	
	public int resisterProject(Project project) throws Exception {
		
		try {
			return projectDao.add(project);
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			
		}
	}
	
	public int deleteProject(int no) throws Exception {
		try {
			return projectDao.delete(no);
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			
		}
	}
	
	public int projectUpdate(ProjectEx project) throws Exception {
		try {
			return projectDao.update(project);
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			
		}
	}

	

}
