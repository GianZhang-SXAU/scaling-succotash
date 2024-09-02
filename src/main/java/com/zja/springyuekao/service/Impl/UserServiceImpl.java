package com.zja.springyuekao.service.Impl;

import com.zja.springyuekao.dao.User;
import com.zja.springyuekao.mapper.UserMapper;
import com.zja.springyuekao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //  静态的集合，模拟数据库的操作
    private static ArrayList<User> users = new ArrayList<User>();

    //向集合中添加元素
    @Override
    public boolean addUser(User user) {
        for (User element : users) {
            if (element.getName().equals(user.getName())) {
                return false;
            }
        }
        users.add(user);
        return true;
    }

    //查询集合中的元素
    @Override
    public ArrayList<User> getUsers() {
        return users;
    }

/*
              注意：以下是对于该集合的删和改，这里我不使用该方法，仅给出实现方法的代码
    //删除集合中的元素
    public boolean deleteUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }

    //修改集合中的元素
    public boolean updateUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getName().equals(user.getName())) {
                users.set(i, user);
                return true;
            }
        }
        return false;
    }

    //根据名字查询集合中的元素
    public User getUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
*/

    //使用MyBatis查询用户
    @Override
    public List<User> queryUser() {
        return userMapper.queryAllUser();
    }

    @Override
    public boolean addUserByName(User user) {
        if (userMapper.selectUserByName(user.getName()) == null) {
            userMapper.insertUser(user);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void deleteUserByName(String name) {
        userMapper.DeleteUserByName(name);
        queryUser();
    }

    @Override
    public User findUserByName(String name) {
        return userMapper.selectUserByName(name);
    }

    @Override
    public boolean UpdateUser(User user) {
        System.out.println(user);
        userMapper.UpdateUser(user);
        return true;
    }
}
