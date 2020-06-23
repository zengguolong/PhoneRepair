package com.project.dragon.dao;

import com.project.dragon.dataobject.WorkerDO;

import java.util.List;

public interface WorkerDOMapper {
    int deleteByPrimaryKey(String workerId);

    int insert(WorkerDO record);

    int insertSelective(WorkerDO record);

    WorkerDO selectByPrimaryKey(String workerId);

    int updateByPrimaryKeySelective(WorkerDO record);

    int updateByPrimaryKey(WorkerDO record);

    List<WorkerDO> queryAll();

    WorkerDO selectByWorkerName(String workerName);
}