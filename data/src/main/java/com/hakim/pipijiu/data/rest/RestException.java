package com.hakim.pipijiu.data.rest;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/1 10:27 <br/>
 * Desc  :
 */
public class RestException extends RuntimeException {
    private int code;

    public RestException(int code, String message) {
        this(message);
        this.code = code;
    }

    public RestException(String detailMessage) {
        super(detailMessage);
    }

    public RestException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public RestException(Throwable throwable) {
        super(throwable);
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        String msg = getLocalizedMessage();
        String name = getClass().getName();
        if (msg == null) {
            return name;
        }

        String trace = name + ": " + msg;

        if (code != 0) {
            trace = name + ": " + code + ", " + msg;
        }

        return trace;
    }
}
