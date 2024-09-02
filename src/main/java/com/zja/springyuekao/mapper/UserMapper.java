package com.zja.springyuekao.mapper;

import com.zja.springyuekao.dao.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> queryAllUser();

    @Select("select * from user where name = #{name} ")
    User selectUserByName(String name);

    @Insert(" INSERT INTO user (name, sex, health, hobby, people, location, work, other)  \n" +
            "        VALUES (#{name}, #{sex}, #{health}, #{hobby}, #{people}, #{location}, #{work}, #{other})  ")
    void insertUser(User user);

    @Delete("DELETE from user where name = #{name}")
    void DeleteUserByName(String name);


    void UpdateUser(User user);
}
