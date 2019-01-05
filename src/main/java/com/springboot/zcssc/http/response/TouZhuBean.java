package com.springboot.zcssc.http.response;

public class TouZhuBean {

    /**
     * message : 无法解析投注内容
     * status : 3
     * {"message":"无法解析投注内容","status":3}
     */

    private String message;
    private int status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TouZhuBean{" +
                "message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
