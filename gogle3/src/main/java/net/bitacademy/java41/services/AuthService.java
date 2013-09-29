package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.dao.MemberDao;
import net.bitacademy.java41.vo.Member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthService {
	@Autowired MemberDao memberDao;
	
	public Member getUserInfo(String email, String password) throws Exception {
		Member member = memberDao.getMember(email, password);
		
		List<String> photos = memberDao.listPhoto(email);

		if (photos.size() > 0) {
			String[] photoNames = new String[photos.size()];
			photos.toArray(photoNames);
			member.setPhotos(photoNames);
		}
		return member;
	}
}














