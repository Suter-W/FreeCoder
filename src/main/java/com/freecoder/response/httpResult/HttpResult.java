package com.freecoder.response.httpResult;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

/**
 * TODO
 *
 * @author : L
 * @version : v1.0
 * @ClassName HttpResult
 * @Description TODO
 * @createTime : 2023/7/12 1:37
 */

@Getter
@ToString
public class HttpResult<T> {
    /**
     * 业务错误码
     */
    private final int code;
    /**
     * 信息描述
     */
    private final String message;
    /**
     * 返回参数
     */
    private final T data;

    public HttpResult(HttpStatus httpStatus, T data) {
        this.code = httpStatus.value();
        this.message = httpStatus.getReasonPhrase();
        this.data = data;
    }
}
