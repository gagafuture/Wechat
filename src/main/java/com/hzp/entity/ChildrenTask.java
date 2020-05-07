package com.hzp.entity;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: GAGA
 * @time: 2020/5/2 16:24
 */
@Data
public class ChildrenTask {
    private Integer ChildrenTaskId;
    private String ChildrenTaskName;
    private Date ChildrenTaskTime;
    private Date ChildrenTaskTimeO;
    private String ChildrenTaskType;
    private String ChildrenTaskImg;
    private Integer ChildrenTaskParentId;
}
