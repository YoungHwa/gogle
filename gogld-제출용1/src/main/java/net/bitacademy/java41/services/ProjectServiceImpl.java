package net.bitacademy.java41.services;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired PlatformTransactionManager txManager;
	@Autowired ProjectDao projectDao;

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public List<Project> getProjectList() throws Exception {
		try{
			List<Project> list = projectDao.list();
			for(Project project : list){
				project.setLeader(projectDao.leaderByProject(project.getNo()));
			}
			return list;

		}catch(Exception e){
			throw e;
		}
	}

	public List<MemberProject> getMyProjects(String email) throws Exception {
		return projectDao.listByMember(email);
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public Project getProject(int no) throws Exception {
		try{

			Project project =  projectDao.get(no);
			project.setLeader(projectDao.leaderByProject(project.getNo()));

			return project;

		}catch(Exception e){
			throw e;
		}
	}
	public List<Member> memberByProject(int no) throws Exception {
		return projectDao.memberByProject(no);
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void addProject(Project project) throws Exception {
		try {
			projectDao.add(project);
			addProjectMember(project.getLeader(), project.getNo(), 0);
			
		} catch (Throwable e) {
			throw e;
		}
	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void updateProject(Project project) throws Exception {
		try {
			projectDao.update(project);

		} catch (Throwable e) {
			throw e;
		} 

	}

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public void removeProject(int no) throws Exception{
		try {
			projectDao.deleteProjectMember(no);
			projectDao.deleteProjectTask(no);
			projectDao.delete(no);

		} catch (Exception e) {
			throw e;

		} 

	}
	
	
	public int addProjectMember(String email, int projectNo, int level) throws Exception {
		
		try {
			
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("email", email);
			paramMap.put("projectNo", projectNo);
			paramMap.put("memberLevel", level);
		
			return projectDao.addProjectMember(paramMap);
			
		} catch (Exception e) {
			throw e;

		} 
	}

	
	
}
