package com.project.dragon.service;

import com.project.dragon.dataobject.WorkerDO;
import com.project.dragon.viewobject.CommentVO;

import java.util.List;

public interface WorkerService {

    //查询所有维修师傅
    List<WorkerDO> queryAll();

    //修改维修工人信息
    void updateWorker(WorkerDO workerDO);

    //删除修改维修工人信息
    void deleteWorker(String workerId);

    //添加维修工人信息
    void addWorker(WorkerDO workerDO);

    //根据id查询工人信息
    WorkerDO byWorkId(String workerId);

    //根据用户名查询该工人是否存在
    WorkerDO byWorkName(String name);

    //修改工人评论信息
    void modifyComment(CommentVO commentVO,String workerId);

}
