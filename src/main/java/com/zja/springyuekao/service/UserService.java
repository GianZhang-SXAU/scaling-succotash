package com.zja.springyuekao.service;


import com.zja.springyuekao.dao.User;

import java.util.ArrayList;
import java.util.List;


public interface UserService {
    boolean addUser(User user);

    public ArrayList<User> getUsers();

    public List<User> queryUser();

    boolean addUserByName(User user);

    public void deleteUserByName(String name);

  public User findUserByName(String name);

    boolean UpdateUser(User user);
}
