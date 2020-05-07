package com.hzp.Utils;

import com.hzp.service.TaskSrevice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.TimerTask;

/**
 * @description:
 * @author: GAGA
 * @time: 2020/5/7 23:44
 */
public class NFDFlightDataTimerTask extends TimerTask {
    @Override
    public void run() {
        try {
            System.out.println("-------------开始执行--------------");
            //执行操作
            ApplicationContext context  =new ClassPathXmlApplicationContext("applicationContext.xml");
            TaskSrevice taskSrevice = context.getBean(TaskSrevice.class);
            taskSrevice.updateChildrenType();
            System.out.println("-------------执行结束--------------");
        } catch (Exception e) {
            System.out.println("-------------解析信息发生异常--------------");
        }
    }

}