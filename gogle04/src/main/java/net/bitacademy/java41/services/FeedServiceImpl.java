package net.bitacademy.java41.services;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.dao.FeedDao;
import net.bitacademy.java41.dao.ProjectDao;
import net.bitacademy.java41.vo.Feed;
import net.bitacademy.java41.vo.Member;
import net.bitacademy.java41.vo.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeedServiceImpl implements FeedService{
	@Autowired PlatformTransactionManager txManager;
	@Autowired FeedDao feedDao;
	@Autowired ProjectDao projectDao;

	
	

	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public String addFeed(String content, String email, int projectNo) throws Exception {
		try {
			List<Member> list = projectDao.memberByProject(projectNo);
			for(Member m : list){
				if(m.getEmail().equals(email)){
					HashMap<String,Object> paramMap = new HashMap<String,Object>();
					paramMap.put("content", content);
					paramMap.put("email", email);
					paramMap.put("projectNo", projectNo);
					feedDao.add(paramMap);	
					return "success";
				}
			}       return "fail";
			
		
		} catch (Throwable e) {
			throw e;
		}
	}

	
	public List<Feed> getFeedList(int projectNo) throws Exception {
		try{
			List<Feed> list = feedDao.list(projectNo);
			return list;

		}catch(Exception e){
			throw e;
		}
	}

//	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
//	public void deleteMember(String email) throws Exception {
//		try {
//			memberDao.deleteAllPhoto(email);
//			memberDao.deleteProjectMember(email);
//			memberDao.delete(email);
//
//
//		} catch (Exception e) {
//			throw e;
//		}
//	}

	


}
