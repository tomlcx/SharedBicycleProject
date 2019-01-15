package com.abc.tyc.controller;

import com.abc.tyc.constant.ResultMsg;
import com.abc.tyc.entity.Person;
import com.abc.tyc.mapper.BikeMapper;
import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

@Controller
@RequestMapping("/data")
public class SharedBicycleController extends BaseController {

    @Resource
    private BikeMapper bikeMapper;

    @ResponseBody
    @PostMapping("/insertPerson")
    public ResultMsg InsertPerson(@RequestBody Person person) {
        Person existPerson = bikeMapper.selectPersonByUsername(person.getUsername());
        if (existPerson == null) {
            person.setCreatetime(new Date());
            bikeMapper.insertPerson(person);
        } else
            return responseError(new JSONArray());
        return responseSuccess(new JSONArray());
    }
}
