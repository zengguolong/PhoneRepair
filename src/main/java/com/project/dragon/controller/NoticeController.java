package com.project.dragon.controller;

import com.project.dragon.dataobject.NoticeDO;
import com.project.dragon.enums.ResultEnum;
import com.project.dragon.exception.DragonException;
import com.project.dragon.service.NoticeService;
import com.project.dragon.utils.KeyUtils;
import com.project.dragon.utils.ResultVOUtils;
import com.project.dragon.viewobject.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    //查询所有通知信息
    @GetMapping("/list")
    public ResultVO list() {
        List<NoticeDO> noticeDOList = noticeService.queryAll();
        return ResultVOUtils.success(noticeDOList);
    }

    //添加一个通知信息
    @GetMapping("/add")
    public ResultVO add(@RequestParam("notice") String notice,
                        @RequestParam("notice_image") String noticeImage) {
        NoticeDO noticeDO = new NoticeDO();
        noticeDO.setId(KeyUtils.genUniqueKey());
        noticeDO.setNotice(notice);
        noticeDO.setNoticeImage(noticeImage);
        noticeService.addNotice(noticeDO);
        return ResultVOUtils.success();
    }

    //删除通知信息
    @GetMapping("/delete")
    public ResultVO delete(@RequestParam("id") String noticeId) {
        NoticeDO noticeDO = noticeService.byNoticeId(noticeId);
        if (noticeDO == null)
            throw new DragonException(ResultEnum.NOTICE_NOT_EXIST);
        noticeService.delete(noticeId);
        return ResultVOUtils.success();
    }

    //更新通知信息
    @GetMapping("/update")
    public ResultVO update(@RequestParam("id") String noticeId,
                           @RequestParam("notice") String notice,
                           @RequestParam("notice_image") String noticeImage) {
        NoticeDO noticeDO = noticeService.byNoticeId(noticeId);
        if (noticeDO == null)
            throw new DragonException(ResultEnum.NOTICE_NOT_EXIST);
        noticeDO.setNotice(notice);
        noticeDO.setNoticeImage(noticeImage);
        noticeService.updateNotice(noticeDO);
        return ResultVOUtils.success();
    }

    //通过id查找通知信息
    @GetMapping("/byId")
    public ResultVO byId(@RequestParam("id") String noticeId) {
        NoticeDO noticeDO = noticeService.byNoticeId(noticeId);
        if (noticeDO == null)
            throw new DragonException(ResultEnum.NOTICE_NOT_EXIST);
        return ResultVOUtils.success(noticeDO);
    }
}
