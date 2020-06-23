package com.project.dragon.service.impl;

import com.google.gson.Gson;
import com.project.dragon.dao.WorkerDOMapper;
import com.project.dragon.dataobject.WorkerDO;
import com.project.dragon.enums.ResultEnum;
import com.project.dragon.exception.DragonException;
import com.project.dragon.service.WorkerService;
import com.project.dragon.viewobject.CommentListVO;
import com.project.dragon.viewobject.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkServiceImpl implements WorkerService {

    @Autowired
    private WorkerDOMapper workerDOMapper;

    @Override
    public List<WorkerDO> queryAll() {
        return workerDOMapper.queryAll();
    }

    @Override
    public void updateWorker(WorkerDO workerDO) {
        workerDOMapper.updateByPrimaryKey(workerDO);
    }

    @Override
    public void deleteWorker(String workerId) {
        workerDOMapper.deleteByPrimaryKey(workerId);
    }

    @Override
    public void addWorker(WorkerDO workerDO) {
        workerDOMapper.insertSelective(workerDO);
    }

    @Override
    public WorkerDO byWorkId(String workerId) {
        return workerDOMapper.selectByPrimaryKey(workerId);
    }

    @Override
    public WorkerDO byWorkName(String name) {
        return workerDOMapper.selectByWorkerName(name);
    }

    @Override
    public void modifyComment(CommentVO commentVO, String workerId) {
        WorkerDO workerDO = workerDOMapper.selectByPrimaryKey(workerId);
        if (workerDO == null)
            throw new DragonException(ResultEnum.WORKER_NOT_EXIST);
        String comment = workerDO.getComment();

        if (comment == null || comment.equals("")) {//数据库里的评论为空的情况下
            List<CommentVO> one = new ArrayList<>();
            one.add(commentVO);
            CommentListVO commentListVO = new CommentListVO();
            commentListVO.setRate(commentVO.getRate());
            commentListVO.setList(one);
            Gson gson = new Gson();
            String str = gson.toJson(commentListVO);
            StringBuilder sb = new StringBuilder(str);
            sb.replace(0, 0, "");
            sb.replace(str.length() - 1, str.length() - 1, "");
            workerDO.setComment(sb.toString());
            workerDOMapper.updateByPrimaryKeySelective(workerDO);
            return;
        }

        Gson gson = new Gson();
        CommentListVO commentListVO = gson.fromJson(comment, CommentListVO.class);
        List<CommentVO> list = commentListVO.getList();
        list.add(commentVO);
        commentListVO.setList(list);
        double sum = 0;
        for (CommentVO temp : list)
            sum += temp.getRate();
        double avg = sum / list.size();
        String str = new DecimalFormat("#.00").format(avg);
        Double allAvg = Double.parseDouble(str);
        commentListVO.setRate(allAvg);
        Gson g = new Gson();
        String commentString = g.toJson(commentListVO);
        StringBuilder sb = new StringBuilder(commentString);
        sb.replace(0, 0, "");
        sb.replace(commentString.length() - 1, commentString.length() - 1, "");
        workerDO.setComment(sb.toString());
        workerDOMapper.updateByPrimaryKeySelective(workerDO);
    }

}
