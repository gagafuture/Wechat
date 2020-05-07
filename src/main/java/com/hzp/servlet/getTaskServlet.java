package com.hzp.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
import java.util.List;

@WebServlet("/getTask")
public class getTaskServlet extends HttpServlet {
    ApplicationContext context  =new ClassPathXmlApplicationContext("applicationContext.xml");
    TaskSrevice taskSrevice = context.getBean(TaskSrevice.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsonstr = JsonUtil.getRequest(request);
        JSONObject jsonObject = JSON.parseObject(jsonstr);
        String appid = jsonObject.getString("appid");
        System.out.println(appid);
        List<Task> tasks = taskSrevice.getAllTask(appid);
        String tasksJson = JSON.toJSONString(tasks);
        System.out.println(tasksJson);
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().append(tasksJson);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
