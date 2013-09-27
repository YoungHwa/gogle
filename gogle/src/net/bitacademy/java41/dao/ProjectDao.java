package net.bitacademy.java41.dao;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.annotation.Component;
import net.bitacademy.java41.vo.Project;
import net.bitacademy.java41.vo.ProjectEx;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

@Component
public class ProjectDao {
	SqlSessionFactory sqlSessionFactory;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public ProjectDao() {}
	
	public List<ProjectEx> getUserProjectList(String email) throws Exception {
		
			
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
		List<ProjectEx> list =
		sqlSession.selectList("net.bitacademy.java41.dao.ProjectMapper.listByMember", email);
			
		sqlSession.commit();
		return list;
		
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
	
	public List<ProjectEx> getProjectList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();

		try {
		  List<ProjectEx> list
		  		= sqlSession.selectList("net.bitacademy.java41.dao.ProjectMapper.list");
		  sqlSession.commit();
		  return list;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
			
		}
	}

	public ProjectEx getProjectInfol(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
		 ProjectEx projectEx = sqlSession.selectOne
				 ("net.bitacademy.java41.dao.ProjectMapper.get",no);
		 sqlSession.commit();
			return projectEx;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
			
		}
	}
	
	public int add(Project project) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
		
			sqlSession.insert(
					"net.bitacademy.java41.dao.ProjectMapper.add", project);
				
				HashMap<String,Object> paramMap = new HashMap<String,Object>();
				paramMap.put("email", project.getLeader());
				paramMap.put("projectNo", project.getNo());
				paramMap.put("memberLevel", 0);
				
				sqlSession.insert(
					"net.bitacademy.java41.dao.ProjectMapper.addProjectMember", 
					paramMap);
				
				sqlSession.commit();
				return project.getNo();
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
			
		}
	}

	public int update(Project project) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
				int count = sqlSession.update(
					"net.bitacademy.java41.dao.ProjectMapper.update", project);
				
				sqlSession.commit();
				return count;

		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}

	public int delete(int no) throws Exception {
		
			SqlSession sqlSession = sqlSessionFactory.openSession();
			
			try {
				sqlSession.delete(
						"net.bitacademy.java41.dao.ProjectMapper.deleteProjectTask", no);
				sqlSession.delete(
						"net.bitacademy.java41.dao.ProjectMapper.deleteProjectMember", no);
				int count = sqlSession.delete(
						"net.bitacademy.java41.dao.ProjectMapper.delete", no);
				
				sqlSession.commit();
				return count;
			} catch (Exception e) {
				sqlSession.rollback();
				throw e;
				
			} finally {
				try {sqlSession.close();} catch (Exception e) {}
				
			}
		}
}
