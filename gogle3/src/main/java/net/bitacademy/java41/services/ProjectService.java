package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.dao.ProjectMemberDao;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.MemberProject;
import net.bitacademy.java41.vo.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component
public class ProjectService {
	@Autowired PlatformTransactionManager txManager;
	@Autowired ProjectDao projectDao;
	@Autowired ProjectMemberDao projectMemberDao;
	
	public List<Project> getProjectList() throws Exception {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus txStatus = txManager.getTransaction(def);
		
		try{
		List<Project> list = projectDao.list();
			txManager.commit(txStatus);
			return list;
		
		}catch(Exception e){
			txManager.rollback(txStatus);
			throw e;
		}
	}
	
	public List<MemberProject> getMyProjects(String email) throws Exception {
		return projectDao.listByMember(email);
	}
	
	public Project getProject(int no) throws Exception {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus txStatus = txManager.getTransaction(def);
		
		try{
			
			Project project =  projectDao.get(no);
			project.setLeader(projectDao.leaderByProject(project.getNo()));
			txManager.commit(txStatus);
		
			return project;
		
		}catch(Exception e){
			txManager.rollback(txStatus);
			throw e;
		}
	}
	public List<Member> memberByProject(int no) throws Exception {
		return projectDao.memberByProject(no);
	}
	
	
	public void addProject(Project project) throws Exception {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus txStatus = txManager.getTransaction(def);
		
		try {
			projectDao.add(project);
			projectMemberDao.add(project.getLeader(), project.getNo(), 0);
			txManager.commit(txStatus);
			
		} catch (Throwable e) {
			txManager.rollback(txStatus);
			throw e;
		}
	}

	public void updateProject(Project project) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus txStatus = txManager.getTransaction(def);
		try {
			projectDao.update(project);
			txManager.commit(txStatus);
			
		} catch (Throwable e) {
			txManager.rollback(txStatus);
			throw e;
		} 
		
	}

	public void removeProject(int no) {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus txStatus = txManager.getTransaction(def);
		try {
			projectDao.delete(no);
			txManager.commit(txStatus);
			
		} catch (Exception e) {
			txManager.rollback(txStatus);
			throw e;
			
		} 
		
	}
}













