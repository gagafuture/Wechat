package com.hzp.service;

import com.hzp.entity.Task;

import java.util.List;

public interface TaskServiceImpl {
    /**
     *
     *
     * @description: 更具用户提供的用户id来查询该用户的任务
     * @param appid
     * @return: list<Task>
     * @author: GAGA
     * @time: 2020/5/4 14:04
     */
    List<Task> getAllTask(String appid);

    /**
     *
     *
     * @description:删除已有的任务
     * @param null
     * @return:
     * @author: GAGA
     * @time: 2020/5/4 14:12
     */
    boolean delTask(Integer id);

    /**
     *
     *
     * @description:通过用户提供的任务内容，然后将内容插入表内，完成任务的设置
     * @param task
     * @return: int
     * @author: GAGA
     * @time: 2020/5/4 14:09
     */
    boolean setTask(Task task);
    /**
     *
     *
     * @description: 更新任务内容
     * @param null
     * @return:
     * @author: GAGA
     * @time: 2020/5/4 20:35
     */
    boolean updateTask(Task task);
}
