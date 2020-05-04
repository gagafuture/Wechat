package com.hzp.entity;

import lombok.Data;

import java.util.List;

/**
 * @description:
 * @author: GAGA
 * @time: 2020/5/2 16:28
 */
@Data
public class Task {
    private Integer TaskId;
    private String TaskAppid;
    private String TaskName;
    private String TaskType;
    private List<ChildrenTask> ChildrenTasks;
    private String TaskTime;
}
