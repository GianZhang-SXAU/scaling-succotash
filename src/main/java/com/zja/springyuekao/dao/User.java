package com.zja.springyuekao.dao;

import lombok.Data;

@Data
public class User {
    private String name;
    private String sex;
    private String health = "绿码";
    private String hobby;
    private String people;
    private String location;
    private String work;
    private String other;

}
