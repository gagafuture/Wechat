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
    @Test
    public void delTask(){
        TaskSrevice taskSrevice = context.getBean(TaskSrevice.class);
        taskSrevice.delTask(1);
    }
    @Test
    public void updateTask(){
        TaskSrevice taskSrevice = context.getBean(TaskSrevice.class);
        List<Task> tasks = taskSrevice.getAllTask("asdasdasdfga13213");
        tasks.get(0).setTaskType("555");
        ChildrenTask childrenTask = new ChildrenTask();
        childrenTask.setChildrenTaskParentId(tasks.get(0).getTaskId());
        childrenTask.setChildrenTaskName("asdasd");
        List<ChildrenTask> childrenTasks = new ArrayList<ChildrenTask>();
        childrenTasks.add(childrenTask);
        tasks.get(0).setChildrenTasks(childrenTasks);
        taskSrevice.updateTask(tasks.get(0));
    }
}