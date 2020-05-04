package com.hzp.servlet;

import com.alibaba.fastjson.JSON;
import com.hzp.Utils.JsonUtil;
import com.hzp.entity.Task;
import com.hzp.service.TaskSrevice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addTask")
public class CreatTaskServlet extends HttpServlet {
    ApplicationContext context  =new  ClassPathXmlApplicationContext("applicationContext.xml");
    TaskSrevice taskSrevice = context.getBean(TaskSrevice.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsonstr = JsonUtil.getRequest(request);
        Task task  = JSON.parseObject(jsonstr,Task.class);
        taskSrevice.setTask(task);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
