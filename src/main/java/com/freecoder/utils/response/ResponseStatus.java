package com.freecoder.utils.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseStatus {
    SUCCESS(HttpStatus.OK, "00000", "OK"),
    CREATED(HttpStatus.CREATED, "00000", "created"),
    NO_CONTENT(HttpStatus.NO_CONTENT, "00000", "no content"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "A0000", "Bad Request"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "B0000", "Internal Server Error"),
    ;

    /** 返回的HTTP状态码,  符合http请求 */
    private HttpStatus httpStatus;
    /** 业务异常码 */
    private String code;
    /** 业务异常信息描述 */
    private String message;

    private ResponseStatus(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }
}
