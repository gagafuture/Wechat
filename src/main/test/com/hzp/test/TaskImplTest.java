package com.hzp.test;

import com.hzp.entity.Task;
import com.hzp.serverImpl.TaskImpl;
import com.hzp.serverImpl.TaskService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class TaskImplTest {
    ApplicationContext context = null;
    @Before
    public void initContext(){
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }
    @Test
    public void getAllTask(){
        TaskImpl taskService = context.getBean(TaskImpl.class);
        Task task = taskService.getAllTask();
        System.out.println(task);
    }
}