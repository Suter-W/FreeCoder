package com.freecoder.response.result;


import lombok.Getter;

@Getter
public class ResultException extends Exception {
    private ResultStatus resultStatus;

    public ResultException() {
        this.resultStatus = ResultStatus.INTERNAL_SERVER_ERROR;
    }

    public ResultException(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }

    public ResultException(String message, ResultStatus resultStatus) {
        super(message);
        this.resultStatus = resultStatus;
    }

    public ResultException(String message, Throwable cause, ResultStatus resultStatus) {
        super(message, cause);
        this.resultStatus = resultStatus;
    }

    public ResultStatus getResultStatus() {
        return this.resultStatus;
    }
}

