package net.bitacademy.java41.services;

import java.util.List;

import net.bitacademy.java41.dao.TaskDao;
import net.bitacademy.java41.vo.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

public interface TaskService {
	 List<Task> getTaskList(int no) throws Exception ;
	 Task getTask(int projectNo, int taskNo)throws Exception;
	 int taskUpdate(Task task) throws Exception;
	 int taskAdd(Task task) throws Exception ;
	 int taskDelete(int projectNo, int taskNo) throws Exception;
}
