package com.hzp.dao;

import com.hzp.entity.ChildrenTask;
import com.hzp.entity.Task;
import lombok.NonNull;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TaskDao {
    List<Task> getAllTask(@Param("appid") @NonNull String appid);
    int setChildren(@NonNull @Param("childrenTasks")List<ChildrenTask> childrenTasks, @NonNull @Param("id")Integer id);
    int setTask(@NonNull Task task);
    int delTask(@Param("id")Integer id);
    int updateChildren(@Param("id")String id, @Param("date") Date date,@Param("img") String img,@Param("type") String type);
    int updateChildrenType();
}
