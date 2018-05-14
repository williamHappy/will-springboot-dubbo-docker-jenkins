package com.springic.exception;

import java.io.Serializable;

/**
 * @author will
 * @date 2017/11/6 下午2:11
 *
 * @description 通用系统异常
 */
public class CommonSysException extends RuntimeException implements Serializable {

    private ExpCodeEnum codeEnum;

    public CommonSysException(ExpCodeEnum codeEnum) {
        super(codeEnum.getMessage());
        this.codeEnum = codeEnum;
    }

    public CommonSysException() {

    }
}
