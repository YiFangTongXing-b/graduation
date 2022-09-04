package com.czf.graduation.controller;


import com.czf.graduation.controller.exception.ControllerException;
import com.czf.graduation.controller.exception.PasswordNotSameException;
import com.czf.graduation.controller.exception.PasswordNullException;
import com.czf.graduation.controller.exception.RepeatCollectException;
import com.czf.graduation.service.exception.*;
import com.czf.graduation.util.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;


//控制层的基类，主要做异常的捕获处理,以及获取登陆用户的uid和username
@Controller
public class BaseController {

    public static final  int OK = 200;    //操作成功的状态码
    public BaseController() {
    }

    //当项目产生异常，会被拦截到此方法中
    @ExceptionHandler({ServiceException.class, ControllerException.class})
    public JsonResult<Void> handleException(Throwable e){
        JsonResult<Void> result = new JsonResult<>();
        if(e instanceof UsernameDuplicatedException){
            result.setState(4000);
            result.setMessage("用户名已经被占用，请重新输入用户名");
        }else if(e instanceof UserNotFoundException){
            result.setMessage("用户不存在");
        }else if(e instanceof InsertException){
            result.setMessage("发生未知错误");
        }else if(e instanceof PasswordNullException){
            result.setMessage("请完整输入三个密码!");
        }else if(e instanceof PasswordNotSameException){
            result.setMessage("新密码与确认密码不一致!!!");
        }else if(e instanceof PasswordNotMatchException){
            result.setMessage("密码不匹配！");
        }else if(e instanceof RepeatCollectException){
            result.setMessage("重复收藏!!!");
        }
        return result;
    }

    //获取登陆用户的uid和username
    public int getUidFromSession(HttpSession session){
        //或者这样写    Integer.parseInt((String) session.getAttribute("uid"));
        return Integer.parseInt(session.getAttribute("uid").toString());
    }
    public String getUsernameFromSession(HttpSession session){
        return session.getAttribute("username").toString();
    }
}
