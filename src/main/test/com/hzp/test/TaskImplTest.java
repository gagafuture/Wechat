package com.hzp.test;

import com.hzp.entity.ChildrenTask;
import com.hzp.entity.Task;
import com.hzp.service.TaskSrevice;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TaskImplTest {
    ApplicationContext context = null;
    @Before
    public void initContext(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @Test
    public void setTask(){
        TaskSrevice taskSrevice = context.getBean(TaskSrevice.class);
        List<ChildrenTask> childrenTasks = new ArrayList<ChildrenTask>();
        for (int i = 0; i < 5; i++) {
            ChildrenTask childrenTask = new ChildrenTask();
            String str = "test"+i;
            System.out.println(str);
            childrenTask.setChildrenTaskName(str);
            childrenTask.setChildrenTaskType(str);
            childrenTasks.add(childrenTask);
        }
        Task task = new Task();
//        task.setChildrenTasks(childrenTasks);
        task.setTaskName("gaga");
        task.setTaskAppid("asdasdasdfga13213");
        taskSrevice.setTask(task);

    }
}