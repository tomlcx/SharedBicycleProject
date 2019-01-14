package com.abc.tyc.constant;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
public class ResultMsg {

    public static final int OK = 0;

    private String msg;

    private int code;

    private Object data;

    private Long count;

    public void setErrorMsg(ErrorMsg errorMsg) {
        setCode(errorMsg.getCode());
        setMsg(errorMsg.getDesc());
    }

    public void setErrorMsg(ErrorMsg errorMsg, String exMsg) {
        setCode(errorMsg.getCode());
        if (StringUtils.isEmpty(exMsg)) {
            setMsg(errorMsg.getDesc());
        } else {
            setMsg(exMsg);
        }
    }

}
