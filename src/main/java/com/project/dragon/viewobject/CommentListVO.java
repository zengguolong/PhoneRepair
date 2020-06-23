package com.project.dragon.viewobject;

import java.util.List;

public class CommentListVO {

    private Double rate;

    private List<CommentVO> list;

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public List<CommentVO> getList() {
        return list;
    }

    public void setList(List<CommentVO> list) {
        this.list = list;
    }
}
