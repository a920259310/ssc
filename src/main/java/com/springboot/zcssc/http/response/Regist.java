package com.springboot.zcssc.http.response;

public class Regist {
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "Regist{" +
                "success=" + success +
                '}';
    }
}
