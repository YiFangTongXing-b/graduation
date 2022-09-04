package com.czf.graduation.controller;

import com.czf.graduation.controller.exception.PasswordNotSameException;
import com.czf.graduation.controller.exception.PasswordNullException;
import com.czf.graduation.domain.User;
import com.czf.graduation.service.UserService;
import com.czf.graduation.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public JsonResult<Void> register(User user){
        userService.userRegister(user);
        return new JsonResult<>(200);
    }

    @RequestMapping("/login")
    public JsonResult<User> login(String username, String password, HttpSession session){
        User user = userService.userLogin(username,password);
        //springboot的session是全局的。这两行完成session的赋值
        session.setAttribute("uid",user.getUid());
        session.setAttribute("username",user.getUsername());
        return new JsonResult<User>(200,user);
    }

    @RequestMapping("/changePassword")
    public JsonResult<Void> changePassword(String oldPassword, String newPassword, String newPassword2, HttpSession session){
        if(oldPassword.equals("") || newPassword.equals("") || newPassword2.equals("")){
            throw new PasswordNullException("密码输入不完整");
        }
        if(!newPassword.equals(newPassword2)){
            throw new PasswordNotSameException("两个新密码不一致");
        }
        int uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        userService.changePassword(uid,username,oldPassword,newPassword);
        return new JsonResult<>(200);
    }
}
