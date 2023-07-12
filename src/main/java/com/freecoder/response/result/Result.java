package com.freecoder.response.result;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Result<T> {
    /**
     * ҵ�������
     */
    private String code;
    /**
     * ��Ϣ����
     */
    private String message;
    /**
     * ���ز���
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
     * ҵ��ɹ�����ҵ������������Ϣ
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
     * ҵ���쳣����ҵ������������Ϣ
     */
    public static Result<Void> failure() {
        return failure(null, null);
    }

    /**
     * ҵ���쳣����ҵ�����,�����ͷ��صĲ���
     */
    public static Result<Void> failure(ResultStatus resultStatus) {
        return failure(resultStatus, null);
    }

    public static Result<Void> failure(String msg) {
        return failure(null, msg);
    }

    /**
     * ҵ���쳣����ҵ�����,�����ͷ��صĲ���
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
