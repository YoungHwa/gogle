package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.annotation.Component;
import net.bitacademy.java41.dao.TaskDao;
import net.bitacademy.java41.vo.Task;

@Component
public class TaskService {
	TaskDao taskDao;
	
	public TaskService setTaskDao(TaskDao taskDao){
		this.taskDao = taskDao;
		return this;
	}

	public List<Task> getTaskList(int no) throws Exception {
		return taskDao.getTaskList(no);
	}
	
	public Task getTask(int projectNo, int taskNo)throws Exception{
		return taskDao.getTask(projectNo, taskNo);
	}
	
	public int taskUpdate(Task task) throws Exception {
		try {
			return taskDao.update(task);
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			
		}
	}
	public int taskAdd(Task task) throws Exception {
		try {
			return taskDao.add(task);
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			
		}
	}
	public int taskDelete(int projectNo, int taskNo) throws Exception {
		try {
			return taskDao.delete(projectNo, taskNo);
			
		} catch (Exception e) {
			throw e;
			
		} finally {
			
		}
	}

}
