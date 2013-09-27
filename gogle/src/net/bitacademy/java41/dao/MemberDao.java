package net.bitacademy.java41.dao;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.annotation.Component;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.Photo;
import net.bitacademy.java41.vo.ProjectMember;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

@Component
public class MemberDao {
	SqlSessionFactory sqlSessionFactory;
	
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	public MemberDao() {	}
	
	public Member getMember(String email, String password) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("email", email);
			paramMap.put("password", password);
			

			Member member = sqlSession.selectOne(
					"net.bitacademy.java41.dao.MemberMapper.getMember",
					paramMap);
			
			List<Photo> list = this.listPhoto(email);
			String[] photos = null;
			if (list.size() > 0) {
				photos = new String[list.size()];
				int index = 0;
				for(Photo photo : list) {
					photos[index] = photo.getFilename();
					index++;
				}
			} member.setPhotos(photos);
			
			
			
			
			sqlSession.commit();
			return member;
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}		
	}
	
	public Member get(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			 
			Member member = sqlSession.selectOne("net.bitacademy.java41.dao.MemberMapper.get",email);
			sqlSession.commit();
			return member;
				
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}

	public int add(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int count = sqlSession.insert(
				"net.bitacademy.java41.dao.MemberMapper.add", member);
			sqlSession.commit();
			return count;
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}

	public List<ProjectMember> getProjectMemberList(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
		List<ProjectMember> list = sqlSession.selectList(
				"net.bitacademy.java41.dao.MemberMapper.getProjectMemberList", no);
		sqlSession.commit();
		return list;
		
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}

	public List<Member> getMemberList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			List<Member> list = 
			sqlSession.selectList("net.bitacademy.java41.dao.MemberMapper.getMemberList");
			sqlSession.commit();
			return list;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}
	
	
	public int update(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			
			int count =sqlSession.update("net.bitacademy.java41.dao.MemberMapper.update",member);
			sqlSession.commit();
			return count;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}


	public int delete(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.delete(
					"net.bitacademy.java41.dao.MemberMapper.deleteMeberImg", email);
			sqlSession.delete(
					"net.bitacademy.java41.dao.MemberMapper.deleteProjectMembs", email);
			int count = sqlSession.delete(
					"net.bitacademy.java41.dao.MemberMapper.delete", email);
			sqlSession.commit();
			return count;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}
	
	public int myInfoChange(Member member) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		try {
			int count = sqlSession.update("net.bitacademy.java41.dao.MemberMapper.myInfoChange",member);
			sqlSession.commit();
			return count;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}
	
	public int changePassword(
			String email, String oldPassword, String newPassword) throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		HashMap<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("email", email);
		paramMap.put("oldPassword", oldPassword);
		paramMap.put("newPassword", newPassword);
		try {
			int count =sqlSession.update("net.bitacademy.java41.dao.MemberMapper.changePassword",paramMap);
			sqlSession.commit();
			return count;
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}

	public int addPhoto(String email, String path) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("email", email);
			paramMap.put("path", path);
			
			int count =sqlSession.insert(
				"net.bitacademy.java41.dao.MemberMapper.addPhoto", paramMap);
			sqlSession.commit();
			return count;
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
			
		} finally {
			try {sqlSession.close();} catch(Exception e) {}
		}
	}

	private List<Photo> listPhoto(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try{
			List<Photo> list=
			sqlSession.selectList("net.bitacademy.java41.dao.MemberMapper.listPhoto",email);
			sqlSession.commit();
			return list;
			
		} catch (Exception e) {
			sqlSession.rollback();
			throw e;
		} finally {
			try {sqlSession.close();} catch (Exception e) {}
		}
	}	
	
}




