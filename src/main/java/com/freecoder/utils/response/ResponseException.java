package com.freecoder.utils.response;

/**
 * TODO
 *
 * @author : L
 * @version : v1.0
 * @ClassName ResponseException
 * @Description TODO
 * @createTime : 2023/7/10 2:52
 */

import lombok.Getter;

@Getter
public class ResponseException extends Exception {
    private ResponseStatus responseStatus;
}
