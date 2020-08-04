package com.modules.common.kafka.model;

public class KafkaLogModel {
    // 日志类型 controller日志： CONTROLLER service日志： SERVICE
    private String logType;

    private Object reqContent;

    private Object resContent;

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public Object getReqContent() {
        return reqContent;
    }

    public void setReqContent(Object reqContent) {
        this.reqContent = reqContent;
    }

    public Object getResContent() {
        return resContent;
    }

    public void setResContent(Object resContent) {
        this.resContent = resContent;
    }

    @Override
    public String toString() {
        return "KafkaLogModel [logType=" + logType + ", reqContent=" + reqContent + ", resContent=" + resContent + "]";
    }
}
