package com.freecoder.utils.response;

/**
 * TODO
 *
 * @author : L
 * @version : v1.0
 * @ClassName Response
 * @Description TODO
 * @createTime : 2023/7/10 2:05
 */
public class Response<T> {
    /** 业务错误码 */
    private String code;
    /** 信息描述 */
    private String message;
    /** 返回参数 */
    private T data;

    private Response(ResponseStatus responseStatus, T data) {
        this.code = responseStatus.getCode();
        this.message = responseStatus.getMessage();
        this.data = data;
    }

    /** 业务成功返回业务代码和描述信息 */
    public static Response<Void> success() {
        return new Response<Void>(ResponseStatus.SUCCESS, null);
    }

    /** 业务成功返回业务代码,描述和返回的参数 */
    public static <T> Response<T> success(T data) {
        return new Response<T>(ResponseStatus.SUCCESS, data);
    }

    /** 业务成功返回业务代码,描述和返回的参数 */
    public static <T> Response<T> success(ResponseStatus responseStatus, T data) {
        if (responseStatus == null) {
            return success(data);
        }
        return new Response<T>(responseStatus, data);
    }

    /** 业务异常返回业务代码和描述信息 */
    public static <T> Response<T> failure() {
        return new Response<T>(ResponseStatus.INTERNAL_SERVER_ERROR, null);
    }

    /** 业务异常返回业务代码,描述和返回的参数 */
    public static <T> Response<T> failure(ResponseStatus responseStatus) {
        return failure(responseStatus, null);
    }

    /** 业务异常返回业务代码,描述和返回的参数 */
    public static <T> Response<T> failure(ResponseStatus responseStatus, T data) {
        if (responseStatus == null) {
            return new Response<T>(ResponseStatus.INTERNAL_SERVER_ERROR, null);
        }
        return new Response<T>(responseStatus, data);
    }
}
