package com.czf.graduation.service;

import com.czf.graduation.domain.User;


public interface UserService {
    void userRegister(User user);   //用户注册
    User userLogin(String username,String password);   //用户登陆
    User getUserByUid(int uid);          //根据uid获取user对象
    int changePassword(int uid,String username,String oldPassword,String newPassword);  //修改密码
}
