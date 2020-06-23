package com.project.dragon.controller;

import com.project.dragon.dataobject.WorkerDO;
import com.project.dragon.enums.ResultEnum;
import com.project.dragon.exception.DragonException;
import com.project.dragon.service.WorkerService;
import com.project.dragon.utils.KeyUtils;
import com.project.dragon.utils.ResultVOUtils;
import com.project.dragon.viewobject.CommentVO;
import com.project.dragon.viewobject.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/worker")
public class AdminWorkerController {

    @Autowired
    private WorkerService workerService;

    //查询所有工人信息
    @GetMapping("/list")
    public ResultVO list() {
        List<WorkerDO> workerDOList = workerService.queryAll();
        return ResultVOUtils.success(workerDOList);
    }

    //添加工人信息
    @GetMapping("/add")
    public ResultVO add(@RequestParam("worker_name") String workerName,
                        @RequestParam("worker_phone") String workerPhone,
                        @RequestParam("worker_card") String workerCard) {
        //查看该工人是否存在
        WorkerDO workerDO = workerService.byWorkName(workerName);
        if (workerDO != null)
            throw new DragonException(ResultEnum.WORKER_EXIST);

        WorkerDO worker = new WorkerDO();
        worker.setWorkerId(KeyUtils.genUniqueKey());
        worker.setWorkerName(workerName);
        worker.setWorkerCard(workerCard);
        worker.setWorkerPhone(workerPhone);
        workerService.addWorker(worker);
        return ResultVOUtils.success("添加成功");
    }

    //删除工人信息
    @GetMapping("/delete")
    public ResultVO delete(@RequestParam("worker_id") String workerId) {
        WorkerDO workerDO = workerService.byWorkId(workerId);
        if (workerDO == null)
            throw new DragonException(ResultEnum.WORKER_NOT_EXIST);
        workerService.deleteWorker(workerId);
        return ResultVOUtils.success("删除成功");
    }

    //更新工人信息
    @GetMapping("/update")
    public ResultVO update(@RequestParam("worker_id") String workerId,
                           @RequestParam("worker_name") String workerName,
                           @RequestParam("worker_phone") String workerPhone,
                           @RequestParam("worker_card") String workerCard,
                           @RequestParam("comment") String comment) {
        WorkerDO workerDO = workerService.byWorkId(workerId);
        if (workerDO == null)
            throw new DragonException(ResultEnum.WORKER_NOT_EXIST);
        WorkerDO worker = new WorkerDO();
        worker.setWorkerId(workerId);
        worker.setWorkerPhone(workerPhone);
        worker.setWorkerCard(workerCard);
        worker.setWorkerName(workerName);
        worker.setComment(comment);
        workerService.updateWorker(worker);
        return ResultVOUtils.success("修改成功");
    }

    //通过id查询工人信息
    @GetMapping("/byWorkerId")
    public ResultVO byWorkerId(@RequestParam("worker_id") String workerId) {
        WorkerDO workerDO = workerService.byWorkId(workerId);
        if (workerDO == null)
            throw new DragonException(ResultEnum.WORKER_NOT_EXIST);
        return ResultVOUtils.success(workerDO);
    }

    //使用postman测试传入json对象时要使用body体中的raw写入json对象
    @RequestMapping(value = "/modifyComment", method = RequestMethod.POST)
    public ResultVO modifyComment(@RequestParam("worker_id") String workerId,
                                  @RequestParam("rate") Double rate,
                                  @RequestParam("content") String content) {
        CommentVO commentVO = new CommentVO();
        commentVO.setRate(rate);
        commentVO.setContent(content);
        workerService.modifyComment(commentVO, workerId);
        return ResultVOUtils.success("添加成功");
    }

}
