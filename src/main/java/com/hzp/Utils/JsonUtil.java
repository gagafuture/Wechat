package com.hzp.Utils;

import com.alibaba.fastjson.JSON;
import com.hzp.entity.Task;

/**
 * @description:
 * @author: GAGA
 * @time: 2020/5/2 16:31
 */
public class JsonUtil {
    public static String TaskToJson(Task task){
        return JSON.toJSONString(task);
    }
    public static Task JsonToTask(String jsonstr){
        return JSON.parseObject(jsonstr,Task.class);
    }
}
