package com.czf.graduation.controller;

import com.czf.graduation.controller.exception.RepeatCollectException;
import com.czf.graduation.domain.UCollection;
import com.czf.graduation.mapper.UCollectionMapper;
import com.czf.graduation.service.UCollectionService;
import com.czf.graduation.util.JsonResult;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UCollectionController extends BaseController{

    @Autowired
    private UCollectionService uCollectionService;

    @Autowired
    private UCollectionMapper uCollectionMapper;


    @RequestMapping("/collections")
    public JsonResult<List<UCollection>> getCollection(HttpSession session){
        int uid = getUidFromSession(session);
        return new JsonResult<>(200,uCollectionService.getCollectionByUid(uid));
    }

    /*
    @RequestMapping("/collections")
    public JsonResult<PageInfo<UCollection>> getCollection(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum,
                                                           @RequestParam(value = "pageSize",defaultValue = "3") int pageSize, HttpSession session){
        int uid = getUidFromSession(session);

        return new JsonResult<>(200,uCollectionService.getCollectionByUid(uid,pageNum,pageSize));
    }
    */

    @RequestMapping("/collect")
    public JsonResult<Integer> collect(int aid,HttpSession session){
        int uid = getUidFromSession(session);
        UCollection tmp = uCollectionMapper.selectCollectionByAidAndUid(aid,uid);
        if(tmp!=null){
            throw new RepeatCollectException("重复收藏");
        }
        int num = uCollectionService.addCollection(aid,uid);
        return new JsonResult<>(200,num);
    }

    @RequestMapping("/cancel")
    public JsonResult<Void> cancel(int cid){
        uCollectionService.deleteOneCollectionByCid(cid);
        return new JsonResult<>(200);
    }


}
