package com.rabitabank.apiwrapper.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "responses")
public class Response {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int response_id;

    @ManyToOne
    @JoinColumn(name = "call_id",nullable = false)
    private Call call;

    @CreatedDate
    private Date insertDate;

    private String value;

    public Response() {
    }

    public Response(Call call, Date insertDate, String value) {
        this.call = call;
        this.insertDate = insertDate;
        this.value = value;
    }

    public int getId() {
        return response_id;
    }

    public void setId(int id) {
        this.response_id = id;
    }

    public Call getParentId() {
        return call;
    }

    public void setParentId(Call call) {
        this.call = call;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
