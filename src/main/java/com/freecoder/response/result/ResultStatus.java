package com.freecoder.response.result;

import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@ToString
@Getter
public enum ResultStatus {
    OK(HttpStatus.OK, "00000", "OK"),
    CREATED(HttpStatus.CREATED, "00000", "Created"),
    NO_CONTENT(HttpStatus.NO_CONTENT, "00000", "No Content"),
    ACCEPTED(HttpStatus.ACCEPTED, "00000", "Accepted"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "A0000", "Bad Request"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "B0000", "Internal Server Error"),
    INVALID_TOKEN(HttpStatus.BAD_REQUEST, "A0001", "Invalid Token"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "A0002", "Unauthorized"),
    NOT_FOUND(HttpStatus.NOT_FOUND,"A0003","Not Found"),
    FORBIDDEN(HttpStatus.FORBIDDEN,"A0004","Forbidden Operation")
    ;

    /** 返回的HTTP状态码,  符合http请求 */
    private HttpStatus httpStatus;
    /** 业务异常码 */
    private String code;
    /** 业务异常信息描述 */
    private String message;

    ResultStatus(HttpStatus httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }
}