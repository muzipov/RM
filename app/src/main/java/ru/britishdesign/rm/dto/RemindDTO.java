package ru.britishdesign.rm.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RemindDTO {

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("remindDate")
    private String remindDate;

    @JsonProperty("remindDetail")
    private String remindDetail;


    public RemindDTO(){

    }
    public RemindDTO(String id, String title, String remindDate, String remindDetail) {
        this.id = id;
        this.title = title;
        this.remindDate = remindDate;
        this.remindDetail = remindDetail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemindDate() {
        return remindDate;
    }

    public void setRemindDate(String remindDate) {
        this.remindDate = remindDate;
    }

    public RemindDTO(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemindDetail() {
        return remindDetail;
    }

    public void setRemindDetail(String remindDetail) {
        this.remindDetail = remindDetail;
    }
}


