package com.springboot.zcssc.http.response;

/**
 * 会话失效响应
 */
public class SessionValidate {

    /**
     * message : 会话已失效，请重新登录系统
     * status : 3
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
}
