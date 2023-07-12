package com.freecoder.wx.model;

public enum EmployeeType {
    COOK("cook"),
    WAITER("waiter");

    private String jobType;

    EmployeeType(String jobType){
        this.jobType = jobType;
    }
}