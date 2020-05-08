package com.hzp.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hzp.entity.ChildrenTask;
import com.hzp.entity.Task;
import com.hzp.service.TaskSrevice;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        String jsonstr = "{\"TaskName\":\"\u03A2��С������ҵ\",\"TaskType\":\"2\",\"ChildrenTasks\":[{\"ChildrenTaskName\":\"�ύ��ҵ\",\"ChildrenTaskTime\":\"2020-05-09\"}],\"TaskAppid\":\"o-F__4zq-g8GG8UpSowltQdWdrdw\",\"TaskTime\":\"2020/05/06 22:38:01\"}\n";
        Task task  = JSON.parseObject(jsonstr,Task.class);
        task.getChildrenTasks().iterator().forEachRemaining((item)->{
            item.setChildrenTaskType("1");
        });
        taskSrevice.setTask(task);
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
    @Test
    public void gettASK() throws ParseException {
        TaskSrevice taskSrevice = context.getBean(TaskSrevice.class);
//        taskSrevice.updateChildrenType();
        String str = "{\"TaskName\":\"dsadasd\",\"TaskType\":\"1\",\"ChildrenTasks\":[{\"ChildrenTaskName\":\"dasdas\",\"ChildrenTaskTime\":\"02:00\"}],\"TaskAppid\":\"o-F__4zq-g8GG8UpSowltQdWdrdw\",\"TaskTime\":\"2020/05/08 11:16:08\"}";
        JSONObject jsonObject = JSON.parseObject(str);
        JSONArray jsonArray = jsonObject.getJSONArray("ChildrenTasks");
        for (int i = 0;i<jsonArray.size();i++){
            jsonArray.getJSONObject(i).put("ChildrenTaskTime","2020-05-08 "+jsonArray.getJSONObject(0).getString("ChildrenTaskTime"));
        }
        jsonObject.put("ChildrenTasks",jsonArray);

    }
    @Test
    public void data() throws ParseException {
        String datestr = "2020/05/07 22:45:40";
        Date date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(datestr);
        System.out.println(date.toString());
    }
}
