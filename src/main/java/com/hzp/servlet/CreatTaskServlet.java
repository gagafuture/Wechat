package com.hzp.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hzp.Utils.JsonUtil;
import com.hzp.entity.ChildrenTask;
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
import java.util.Collections;
import java.util.Comparator;

@WebServlet("/addTask")
public class CreatTaskServlet extends HttpServlet {
    ApplicationContext context  =new  ClassPathXmlApplicationContext("applicationContext.xml");
    TaskSrevice taskSrevice = context.getBean(TaskSrevice.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsonstr = JsonUtil.getRequest(request);
        System.out.println(jsonstr);
        JSONObject jsonObject = JSON.parseObject(jsonstr);
        System.out.println(jsonObject);
        if (jsonObject.getString("TaskType").equals("1")){
            JSONArray jsonArray = jsonObject.getJSONArray("ChildrenTasks");
            for (int i = 0;i<jsonArray.size();i++){
                jsonArray.getJSONObject(i).put("ChildrenTaskTime","2020-05-08 "+jsonArray.getJSONObject(0).getString("ChildrenTaskTime"));
            }
            jsonObject.put("ChildrenTasks",jsonArray);
        }
        jsonstr  = JSON.toJSONString(jsonObject);
        System.out.println(jsonstr);
        Task task  = JSON.parseObject(jsonstr,Task.class);
        task.getChildrenTasks().iterator().forEachRemaining((item)->{
            item.setChildrenTaskType("1");
        });
        Collections.sort(task.getChildrenTasks(), new Comparator<ChildrenTask>() {
            @Override
            public int compare(ChildrenTask o1, ChildrenTask o2) {
                return o1.getChildrenTaskTime().compareTo(o2.getChildrenTaskTime());
            }
        });
        taskSrevice.setTask(task);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
