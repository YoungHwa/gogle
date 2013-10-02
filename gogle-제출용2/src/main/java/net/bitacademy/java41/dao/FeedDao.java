package net.bitacademy.java41.dao;

import java.util.List;
import java.util.Map;

import net.bitacademy.java41.vo.Feed;


public interface FeedDao {
	 
	int add(Map<String,Object> paramMap) throws Exception;
	List<Feed> list(int projectNo) throws Exception; 
	 void delete(int fno) throws Exception;
}
