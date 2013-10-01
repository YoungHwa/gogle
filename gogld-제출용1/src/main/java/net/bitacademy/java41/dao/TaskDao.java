package net.bitacademy.java41.dao;

import java.util.List;
import java.util.Map;

import net.bitacademy.java41.vo.Task;

public interface TaskDao {
	
	 Task getTask(Map<String,Object> paramMap) throws Exception;
	 List<Task> getTaskList(int no) throws Exception;
	 int update(Task task) throws Exception;
	 int add(Task task) throws Exception;
	 int delete(Map<String,Object> paramMap) throws Exception;
	}


