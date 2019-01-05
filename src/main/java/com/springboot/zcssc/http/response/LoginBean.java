package com.springboot.zcssc.http.response;

/**
 * 登陆响应实体
 */
public class LoginBean {

    /**
     * message : _OLID_=2f65475d916cb0538e5c1df4bd13a0c4
     * success : true
     * httpsEnable : 1
     */

    private String message;
    private boolean success;
    private int httpsEnable;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getHttpsEnable() {
        return httpsEnable;
    }

    public void setHttpsEnable(int httpsEnable) {
        this.httpsEnable = httpsEnable;
    }
}
