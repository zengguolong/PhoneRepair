package com.project.dragon.dataobject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyImagesDAO {
    private String id;

    private String myimages;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMyimages() {
        return myimages;
    }

    public void setMyimages(String myimages) {
        this.myimages = myimages == null ? null : myimages.trim();
    }
}