package com.abc.tyc.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Person {
    private long id;

    private String username;

    private String password;

    //1用户 2管理员 3维修员
    private int role;

    private Date createtime;
}
