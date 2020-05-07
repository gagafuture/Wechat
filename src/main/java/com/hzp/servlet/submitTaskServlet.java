package com.hzp.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hzp.Utils.JsonUtil;
import com.hzp.service.TaskSrevice;
import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/submitTask")
public class submitTaskServlet extends HttpServlet {
    ApplicationContext context  =new ClassPathXmlApplicationContext("applicationContext.xml");
    TaskSrevice taskSrevice = context.getBean(TaskSrevice.class);
    @SneakyThrows
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsonstr = JsonUtil.getRequest(request);
        System.out.println(jsonstr);
        JSONObject jsonObject = JSON.parseObject(jsonstr);
        String type = jsonObject.getString("type");
        String id = jsonObject.getString("id");
        String parentid = jsonObject.getString("parentid");
        String appid = jsonObject.getString("appid");
        String datestr = jsonObject.getString("date");
        Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(datestr);
        String img = "https://gaga.gagafuture.com/wechat_timer/photo/"+appid+"/"+parentid+"-"+id+".jpg";
        boolean res = taskSrevice.updateChildren(id,date,img,type);
        System.out.println(res);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
