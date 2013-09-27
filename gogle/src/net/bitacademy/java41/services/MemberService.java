package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.annotation.Component;
import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.ProjectEx;

@Component
public class MemberService {
	MemberDao memberDao;
	ProjectDao projectDao;

	
	public MemberService setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
		return this;
	}
	public MemberService setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
		return this;
	}

	public int signUp(Member member) throws Exception {
		try {
			int count = memberDao.add(member);
			String[] photos = member.getPhotos();
			if (photos != null) {
				for( String path : photos ) {
					memberDao.addPhoto(member.getEmail(), path);
				}
			}
			return count;
			
		} catch (Exception e) {
			throw e;
			
		} finally {
		}
		
	}

	public int addMember(Member member) throws Exception {
		try {
			return memberDao.add(member);
			
		} catch (Exception e) {
			throw e;
			
		} finally {
		}
		
	}

	public List<Member> getTotalMemberList() throws Exception {
		return memberDao.getMemberList();
	}

	public Member getMemberInfo(String email) throws Exception {
		return memberDao.get(email);
	}

	public List<ProjectEx> getUserProjectList(String email) throws Exception {
		return projectDao.getUserProjectList(email);
	}
	
	public int deleteMember(String email) throws Exception {
		try {
			return memberDao.delete(email);
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			
		}
		
	}
	
	public int isChangePassword(String email, String oldPassword
			, String newPassword) throws Exception {
		try {
			return memberDao.changePassword(email, oldPassword, newPassword);
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			
		}	
	}
	
	public int updateMemberInfo(Member member) throws Exception {
		try {
			int count = memberDao.update(member);
			String[] photos = member.getPhotos();
			if (photos != null) {
				for( String path : photos ) {
					memberDao.addPhoto(member.getEmail(), path);
				}
			}
			return count;
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			
		}
	}
	
	public int myInfoChange(Member member) throws Exception {
		try {
			int count = memberDao.myInfoChange(member);
			String[] photos = member.getPhotos();
			if (photos != null) {
				for( String path : photos ) {
					memberDao.addPhoto(member.getEmail(), path);
				}
			}
			return count;
		} catch (Exception e) {
			throw e;
			
		} finally {
			
		}
	}


}
