package com.hzp.serverImpl;

import com.hzp.dao.TaskDao;
import com.hzp.entity.Task;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.ws.ServiceMode;

/**
 * @description:
 * @author: GAGA
 * @time: 2020/5/2 19:01
 */
@Service
public class TaskImpl implements TaskService {
    private TaskDao taskDao;
    @Resource
    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }
    @Override
    public Task getAllTask() {
        return this.taskDao.getAllTask();
    }
}
