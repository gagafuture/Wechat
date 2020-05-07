package com.hzp.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hzp.Utils.HttpUtil;
import com.hzp.Utils.JsonUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jsonstr = JsonUtil.getRequest(request);
        JSONObject jsonObject = JSON.parseObject(jsonstr);
        String code = jsonObject.getString("code");
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=%s" +
                "&secret=%s" +
                "&js_code=%s" +
                "&grant_type=authorization_code";
        String appid = "wxf9210a08379af144";
        String secret = "1bbcb4b6341495e1a3073cc9791b8b51";
        url = String.format(url,appid,secret,code);
        String result  = HttpUtil.sendGet(url);
//        String a = "{\"session_key\":\"Y1BSBdfmNbx1FTXz8In1gA==\",\"openid\":\"o-F__4zq-g8GG8UpSowltQdWdrdw\"}";
        response.getWriter().append(result);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
