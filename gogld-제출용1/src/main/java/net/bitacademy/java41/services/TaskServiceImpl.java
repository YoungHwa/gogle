package net.bitacademy.java41.services;

import java.util.HashMap;
import java.util.List;

import net.bitacademy.java41.dao.TaskDao;
import net.bitacademy.java41.vo.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TaskServiceImpl implements TaskService {
	@Autowired PlatformTransactionManager txManager;
	@Autowired TaskDao taskDao;

	public List<Task> getTaskList(int no) throws Exception {
		return taskDao.getTaskList(no);
	}
	
	
	public Task getTask(int projectNo, int taskNo)throws Exception{
		HashMap<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("projectNo", projectNo);
		paramMap.put("taskNo", taskNo);
		return taskDao.getTask(paramMap);
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public int taskUpdate(Task task) throws Exception {
		try {
			return taskDao.update(task);
		} catch (Exception e) {
			throw e;
			
		} finally {
			
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public int taskAdd(Task task) throws Exception {
		try {
			return taskDao.add(task);
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			
		}
	}
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Throwable.class)
	public int taskDelete(int projectNo, int taskNo) throws Exception {
		try {
			HashMap<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("projectNo", projectNo);
			paramMap.put("taskNo", taskNo);
			return taskDao.delete(paramMap);
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			
		}
	}

}
