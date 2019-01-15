package com.abc.tyc.controller;


import com.abc.tyc.constant.Constant;
import com.abc.tyc.constant.ErrorMsg;
import com.abc.tyc.constant.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
public class BaseController {
    @Autowired
    protected HttpServletRequest request;

    public ResultMsg setResponse(Object data, Boolean bool){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setData(data);
        if (bool){
            resultMsg.setCode(Constant.STAT_SUCCESS);
            resultMsg.setMsg(Constant.RETURN_SUCCESS);
        }else {
            resultMsg.setCode(Constant.STAT_ERROR);
            resultMsg.setMsg(Constant.RETURN_ERROR);
        }

        return resultMsg;
    }

    /**
     * 返回成功，状态码为200
     * @param data
     * @return
     */
    public ResultMsg responseSuccess(Object data){
        return setResponse(data,true);
    }

    public ResultMsg responseError(Object data){
        return setResponse(data,false);
    }

    /**
     * 返回成功，状态码为0
     * @param data
     * @return
     */
    public ResultMsg success(Object data){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setCode(ErrorMsg.OK.getCode());
        resultMsg.setData(data);
        resultMsg.setMsg(ErrorMsg.OK.getDesc());
        return resultMsg;
    }

    public ResultMsg dtoSuccess(Object data, Long count){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.setCode(ErrorMsg.OK.getCode());
        resultMsg.setData(data);
        resultMsg.setMsg(ErrorMsg.OK.getDesc());
        return resultMsg;
    }


}
