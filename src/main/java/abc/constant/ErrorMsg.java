package com.abc.tyc.constant;


public enum ErrorMsg {
    /**
     * 操作成功
     */
    OK(0, "操作成功"),

    /**
     * 系统内部错误
     */
    INNER_ERROR(2, "系统内部错误"),


    UNKNOWN(3, "未知错误"),

    /**
     * 登录参数
     */
    //部分或全部参数为空
    PARAM_IS_NULL(5, "请求参数为空或部分为空"),


    /**
     * 参数格式
     */
    PARAM_WRONG(7, "参数格式错误"),

    /**
     * 不支持请求方法
     */
    REQUEST_METHOD_ERROR(21, "请求方法不匹配"),


    SSO_TOKEN_VERIFY_FAIL(101, "token验证失败"),

    SEARCH_EXCEPTION(201, "搜索异常");


    private int code;

    private String desc;

    ErrorMsg(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


}
