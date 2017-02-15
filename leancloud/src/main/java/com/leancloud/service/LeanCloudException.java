package com.leancloud.service;

/**
 * OkLine(HangZhou) co., Ltd. <br/>
 * Author: Shi Haijun <br/>
 * Email : haijun@okline.cn <br/>
 * Date  : 2016/12/1 10:27 <br/>
 * Desc  :
 */
public class LeanCloudException extends RuntimeException {
    /**
     * LeanCloud请求错误
     */
    public static final  int CODE_REQUEST_EXCEPTION = 100;
    private int code;

    /**
     * @param code    error code
     * @param message error description
     */
    public LeanCloudException(int code, String message) {
        this(message);
        this.code = code;
    }

    public LeanCloudException(String detailMessage) {
        super(detailMessage);
    }

    public LeanCloudException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public LeanCloudException(Throwable throwable) {
        super(throwable);
    }

    /**
     * LeanCloud error code
     */
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
