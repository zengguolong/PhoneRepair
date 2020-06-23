package com.project.dragon.dataobject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WorkerDO {

    @Id
    private String workerId;

    private String workerName;

    private String workerPhone;

    private String workerCard;

    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getWorkerId() {
        return workerId;
    }

    public void setWorkerId(String workerId) {
        this.workerId = workerId == null ? null : workerId.trim();
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName == null ? null : workerName.trim();
    }

    public String getWorkerPhone() {
        return workerPhone;
    }

    public void setWorkerPhone(String workerPhone) {
        this.workerPhone = workerPhone == null ? null : workerPhone.trim();
    }

    public String getWorkerCard() {
        return workerCard;
    }

    public void setWorkerCard(String workerCard) {
        this.workerCard = workerCard == null ? null : workerCard.trim();
    }
}