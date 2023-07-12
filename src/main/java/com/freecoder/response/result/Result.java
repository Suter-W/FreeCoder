package com.freecoder.response.result;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Result<T> {
    /**
     * 业务错误码
     */
    private String code;
    /**
     * 信息描述
     */
    private String message;
    /**
     * 返回参数
     */
    private T data;

    private Result(ResultStatus resultStatus, String msg, T data) {
        this.code = resultStatus.getCode();
        this.message = msg;
        if (msg == null) {
            this.message = resultStatus.getMessage();
        }
        this.data = data;
    }

    /**
     * 业务成功返回业务代码和描述信息
     */
    public static Result<Void> success() {
        return success(null, null);
    }

    public static Result<Void> success(ResultStatus resultStatus) {
        return success(resultStatus, null);
    }

    public static <T> Result<T> success(T data) {
        return success(null, data);
    }

    public static <T> Result<T> success(ResultStatus resultStatus, T data) {
        return success(resultStatus, null, data);
    }

    public static <T> Result<T> success(ResultStatus resultStatus, String msg, T data) {
        if (resultStatus == null){
            return new Result<T>(ResultStatus.OK, msg, data);
        }
        return new Result<T>(resultStatus, msg, data);
    }

    /**
     * 业务异常返回业务代码和描述信息
     */
    public static Result<Void> failure() {
        return failure(null, null);
    }

    /**
     * 业务异常返回业务代码,描述和返回的参数
     */
    public static Result<Void> failure(ResultStatus resultStatus) {
        return failure(resultStatus, null);
    }

    public static Result<Void> failure(String msg) {
        return failure(null, msg);
    }

    /**
     * 业务异常返回业务代码,描述和返回的参数
     */
    public static Result<Void> failure(ResultStatus resultStatus, String msg) {
        return failure(resultStatus, msg, null);
    }

    public static <T> Result<T> failure(ResultStatus resultStatus, String msg, T data) {
        if (resultStatus == null) {
            return new Result<T>(ResultStatus.BAD_REQUEST, msg, data);
        }
        return new Result<T>(resultStatus, msg, data);
    }


    public static <T> Result<T> error() {
        return error(null, null);
    }

    public static <T> Result<T> error(String msg) {
        return error(msg, null);
    }

    public static <T> Result<T> error(T err) {
        return error(null, err);
    }

    public static <T> Result<T> error(String msg, T err) {
        return error(null, msg, err);
    }

    public static <T> Result<T> error(ResultStatus resultStatus, String msg, T err) {
        if (resultStatus == null) {
            return new Result<T>(ResultStatus.INTERNAL_SERVER_ERROR, msg, err);
        }
        return new Result<T>(resultStatus, msg, err);
    }

    public static <T> Result<T> response(ResultStatus resultStatus, String msg, T data) {
        return new Result<T>(resultStatus, msg, data);
    }
}
