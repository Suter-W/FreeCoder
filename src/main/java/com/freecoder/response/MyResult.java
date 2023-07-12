package com.freecoder.response;

/**
 * 统一响应结果封装类
 */
public class MyResult {
    private Integer code;//1 成功 , 0 失败
    private String msg; //提示信息
    private Object data; //数据 data

    public MyResult() {
    }

    public MyResult(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static MyResult success() {
        return new MyResult(1, "success", null);
    }

    public static MyResult success(String msg) {
        return new MyResult(1, msg, null);
    }
    public static MyResult success(Object data) {
        return new MyResult(1, "success", data);
    }

    public static MyResult success(String msg, Object data) {
        return new MyResult(1, msg, data);
    }

    public static MyResult error(String msg) {
        return new MyResult(0, msg, null);
    }

    public static MyResult error(Object data) {
        return new MyResult(0, "error", data);
    }

    public static MyResult error(String msg, Object data) {
        return new MyResult(0, msg, data);
    }

    @Override
    public String toString() {
        return "MyResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
