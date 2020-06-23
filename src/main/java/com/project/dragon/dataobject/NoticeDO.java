package com.project.dragon.dataobject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NoticeDO {

    @Id
    private String id;

    private String notice;

    private String noticeImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice == null ? null : notice.trim();
    }

    public String getNoticeImage() {
        return noticeImage;
    }

    public void setNoticeImage(String noticeImage) {
        this.noticeImage = noticeImage == null ? null : noticeImage.trim();
    }
}