package com.hzp.service;

import com.hzp.dao.TaskDao;
import com.hzp.entity.Task;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description:
 * @author: GAGA
 * @time: 2020/5/2 19:01
 */
@Service
public class TaskSrevice implements TaskServiceImpl {
    private TaskDao taskDao;
    @Resource
    private void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }


    @Override
    public List<Task> getAllTask(String appid) {
        return this.taskDao.getAllTask(appid);
    }

//    @Override
//    public int setChildren(List<ChildrenTask> childrenTasks, Integer id) {
//        return 0;
//    }

    @Override
    public boolean setTask(Task task) {
        int setTaskBoolean = 0;
        int setChildrenBoolean = 0;
        System.out.println(task.getChildrenTasks());
        if (!(task.getChildrenTasks()==null)){
            setTaskBoolean =this.taskDao.setTask(task);
            setChildrenBoolean = this.taskDao.setChildren(task.getChildrenTasks(),task.getTaskId());
        }
        return setChildrenBoolean > 0 && setTaskBoolean > 0;
    }
}
