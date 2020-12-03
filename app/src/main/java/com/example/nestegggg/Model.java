package com.example.nestegggg;

public class Model {
    String id, image, title, amount, addTimeStamp, updateTimeStamp;

    public Model(String id, String image, String title, String amount, String addTimeStamp, String updateTimeStamp) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.amount = amount;
        this.addTimeStamp = addTimeStamp;
        this.updateTimeStamp = updateTimeStamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAddTimeStamp() {
        return addTimeStamp;
    }

    public void setAddTimeStamp(String addTimeStamp) {
        this.addTimeStamp = addTimeStamp;
    }

    public String getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(String updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }
}
