package net.bitacademy.java41.controls.task;

import java.io.File;
import java.sql.Date;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;

import net.bitacademy.java41.annotation.Component;
import net.bitacademy.java41.controls.PageControl;
import net.bitacademy.java41.services.TaskService;
import net.bitacademy.java41.vo.Task;

@Component("/task/add.do")
public class TaskAddControl implements PageControl {
	String rootRealPath;
	TaskService taskService;
	long currTime = 0;
	int count = 0;
	
	public void setRootRealPath(String rootRealPath) {
		this. rootRealPath = rootRealPath;
	}
	public TaskAddControl setTaskService(TaskService taskService) {
		this.taskService = taskService;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		@SuppressWarnings("unchecked")
		Map<String, Object> params = (Map<String, Object>) model.get("params");
		

		FileItem uiProto = (FileItem)params.get("uiProto");
		
		String filename = null;
		if(uiProto.getSize()>0){
		filename = this.getNewFileName();
		String path = rootRealPath + "file/" + filename;
		uiProto.write(new File(path));
		}
		
		Task task = new Task()
								.setProjectNo( Integer.parseInt( (String) params.get("projectNo")) )
								.setTitle( (String) params.get("title") )
								.setUiProtoUrl( filename )
								.setContent( (String) params.get("content") )
								.setStartDate( Date.valueOf((String) params.get("startDate")) )
								.setEndDate( Date.valueOf((String) params.get("endDate")) )
								.setStatus( Integer.parseInt((String) params.get("status")) )
								;
		
		taskService.taskAdd(task);
			
		return "redirect:../task/list.do?projectNo=" + task.getProjectNo();
	}
	
	synchronized private String getNewFileName() {
		long millis = System.currentTimeMillis();
		if (currTime != millis) {
			currTime = millis;
			count = 0;
		}
		return "task" + millis + "_" + (++count);
	}
	
}