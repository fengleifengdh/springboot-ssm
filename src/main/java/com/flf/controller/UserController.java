package com.flf.controller;

import com.flf.dao.UserMapper;
import com.flf.entity.User;
import com.flf.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Resource
    private UserMapper userMapper;
    @Resource
    private IUserService userService;
//    @Resource
//    private ClassesMapper classesMapper;
@RequestMapping(value = "/aa")
public ModelAndView test(ModelAndView mv) {
    mv.setViewName("/greeting");
    mv.addObject("title","欢迎使用Thymeleaf!");
    return mv;
}

    @RequestMapping("/qq")
    public String in(HttpServletRequest request, Model model) {
//        int userId = Integer.parseInt(request.getParameter("id"));
//        User user = this.userService.getUserById(userId);
        return "index";
    }

    @RequestMapping("/showUser")
    public String toIndex(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
//        model.addAttribute("user", user);
//        ClassesAndTeacher ClassesAndTeacher =classesMapper.getClass(userId);
//
//        ClassesAndTeacherAndStudent classesAndTeacherAndStudent =classesMapper.getClass3(userId);
////        PlatformTransactionManager i =
//        int n = classesMapper.getNum();
////        org.springframework.jdbc.datasource.DataSourceTransactionManager
        return "User";
    }
    @RequestMapping("/s")
    @ResponseBody
    public int toIndex1(HttpServletRequest request, Model model) {
//        int userId = Integer.parseInt(request.getParameter("id"));
//        User user = this.userService.getUserById(userId);
//        model.addAttribute("user", user);
//        ClassesAndTeacher ClassesAndTeacher =classesMapper.getClass(1);

//        ClassesAndTeacherAndStudent classesAndTeacherAndStudent =classesMapper.getClass3(1);
//        int n = classesMapper.getNum();
//        List<User> users = userMapper.getUseByAge(3);
//        User user = new User();
//        user.setAge(1);
//        user.setPassword("1");
//        userMapper.insert(user);
        return userService.insertBy();
    }
    /*测试多视图*/
    @RequestMapping("/view")
    public String view(HttpServletRequest request, Model model) {
//        int userId = Integer.parseInt(request.getParameter("id"));
//        User user = this.userService.getUserById(userId);
//        model.addAttribute("user", user);
//        ClassesAndTeacher ClassesAndTeacher =classesMapper.getClass(userId);

//        ClassesAndTeacherAndStudent classesAndTeacherAndStudent =classesMapper.getClass3(userId);
//        PlatformTransactionManager i =
//        int n = classesMapper.getNum();
//        org.springframework.jdbc.datasource.DataSourceTransactionManager
        User user = this.userService.getUserById(1);
        model.addAttribute("user", user);
            return "u1.ftl";
//        return "u1.jsp";
    }
}