package com.abc.tyc.constant;

import com.alibaba.druid.util.StringUtils;
import lombok.Data;

@Data
public class ResultMsg {

    public static final int OK = 0;

    private String msg;

    private int code;

    private Object data;


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
