package com.zja.springyuekao.controller;


import com.zja.springyuekao.dao.User;
import com.zja.springyuekao.mapper.UserMapper;
import com.zja.springyuekao.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserInputController {

    //记录对象报错信息的日志
    private static final Log logeer = LogFactory.getLog(UserInputController.class);
    HashMap<String, String> people = new HashMap<String, String>();

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    private void initPeople() {
        people.put("赵鹏程", "赵鹏程");
        people.put("张建安", "张建安");

        people.put("白晓宇sb", "白晓宇sb");

        people.put("杨卿远", "杨卿远");
    }

    @RequestMapping("/input")
    public String UserInput(Model model) {
        initPeople();
        model.addAttribute("hobby", new String[]{"踢足球", "打篮球", "打游戏", "学习知识"});
        model.addAttribute("people", people);
        model.addAttribute("health", new String[]{"绿码", "黄码", "红码"});
        model.addAttribute("work", new String[]{"学生", "程序员", "老师", "公务员"});
        model.addAttribute("location", new String[]{"晋中", "大同", "临汾", "长治"});
        model.addAttribute("user", new User());

        return "userAdd";
    }

    @RequestMapping("/list")
    public String UserList(@ModelAttribute User user, Model model) throws IOException {

        List<User> users = userService.getUsers();
        List<User> users1 = userMapper.queryAllUser();
        System.out.println(users1);
        model.addAttribute("users", users);
        model.addAttribute("users",users1);
        return "userList";
    }

    @RequestMapping("/save")
    public String addUser(@ModelAttribute User user, Model model) {
//        if (userService.addUser(user)) {
        if (userService.addUserByName(user)) {
            logeer.info("保存成功");
            return "redirect:/user/list";
        } else {
            logeer.info("保存失败");
            initPeople();
            model.addAttribute("hobby", new String[]{"踢足球", "打篮球", "打游戏", "学习知识"});

            model.addAttribute("people", people);
            model.addAttribute("health", new String[]{"绿码", "黄码", "红码"});
            model.addAttribute("work", new String[]{"学生", "程序员", "老师", "公务员"});
            model.addAttribute("location", new String[]{"晋中", "大同", "临汾", "长治"});
            model.addAttribute("user", new User());
            if (user.getName() == null) {
                model.addAttribute("waring", "用户名不可为空");
            }
            model.addAttribute("waring", "用户" + user.getName() + "已被录入，无法再次录入");
            return "userAdd";
        }

    }

    @RequestMapping("/delete")
    public String deleteUser(HttpServletRequest request, Model model){
        String name = request.getParameter("name");
        System.out.println(name);
        userService.deleteUserByName(name);
        List<User> users1 = userMapper.queryAllUser();
        model.addAttribute("users",users1);
//        return "redirect:/user/list";
        return "userList";
    }

    @RequestMapping("/update")
    public String UpdateUser(HttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        User user = userService.findUserByName(name);

        initPeople();
        model.addAttribute("hobby", new String[]{"踢足球", "打篮球", "打游戏", "学习知识"});

        model.addAttribute("people", people);
        model.addAttribute("health", new String[]{"绿码", "黄码", "红码"});
        model.addAttribute("work", new String[]{"学生", "程序员", "老师", "公务员"});
        model.addAttribute("location", new String[]{"晋中", "大同", "临汾", "长治"});
        model.addAttribute("user", user);
        return "userUpdata";
    }
    @RequestMapping("/updatesave")
    public String UpdateUser(@ModelAttribute User user, Model model) {
//        if (userService.addUser(user)) {
        if (userService.UpdateUser(user)) {
            logeer.info("保存成功");
            return "redirect:/user/list";
        } else {
            logeer.info("保存失败");
            initPeople();
            model.addAttribute("hobby", new String[]{"踢足球", "打篮球", "打游戏", "学习知识"});

            model.addAttribute("people", people);
            model.addAttribute("health", new String[]{"绿码", "黄码", "红码"});
            model.addAttribute("work", new String[]{"学生", "程序员", "老师", "公务员"});
            model.addAttribute("location", new String[]{"晋中", "大同", "临汾", "长治"});
            model.addAttribute("user", new User());
            if (user.getName() == null) {
                model.addAttribute("waring", "用户名不可为空");
            }
            model.addAttribute("waring", "用户" + user.getName() + "已被录入，无法再次录入");
            return "userAdd";
        }
    }

}
