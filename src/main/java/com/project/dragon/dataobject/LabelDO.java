package com.project.dragon.dataobject;

public class LabelDO {
    private String id;

    private String phoneLabel;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPhoneLabel() {
        return phoneLabel;
    }

    public void setPhoneLabel(String phoneLabel) {
        this.phoneLabel = phoneLabel == null ? null : phoneLabel.trim();
    }
}