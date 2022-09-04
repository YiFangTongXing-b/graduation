package com.czf.graduation.service.impl;

import com.czf.graduation.domain.User;
import com.czf.graduation.mapper.UserMapper;
import com.czf.graduation.service.UserService;
import com.czf.graduation.service.exception.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void userRegister(User user) {
        User tmp = userMapper.findByUsername(user.getUsername());
        if(tmp!=null){
            throw new UsernameDuplicatedException("service层出现异常:用户名已被占用");
        }
        int result = userMapper.insertUser(user);
        if(result==0){
            throw new InsertException("service层出现异常:用户注册失败");
        }
    }

    @Override
    public User userLogin(String username, String password){
        User user = userMapper.findByUsername(username);
        if(user==null){
            throw new UserNotFoundException("service层出现异常:没找到用户名");
        }
        String pass = user.getPassword();
        if(!pass.equals(password)){
            throw new PasswordNotMatchException("密码错误");
        }
        User ans = new User();
        ans.setUid(user.getUid());       //这里必须赋值，否则控制层的user对象的uid一直是0
        ans.setUsername(username);
        ans.setPassword(password);
        return ans;
    }

    @Override
    public User getUserByUid(int uid) {
        return userMapper.selectUserByUid(uid);
    }

    @Override
    public int changePassword(int uid, String username, String oldPassword, String newPassword) {
        //首先根据uid可以获取user信息（用户名和密码）
        User user = userMapper.selectUserByUid(uid);
        String password = user.getPassword();
        if(!oldPassword.equals(password)){
            throw new PasswordNotMatchException("密码错误，请重新输入");
        }
        int result = userMapper.updatePassword(uid,username,newPassword);
        if(result!=1){
            throw new UpdatePasswordException("更新密码失败");
        }
        return result;
    }
}
