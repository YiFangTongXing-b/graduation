package com.czf.graduation.service;

import com.czf.graduation.domain.UCollection;
import com.github.pagehelper.PageInfo;

import java.util.List;


public interface UCollectionService {
    List<UCollection> getCollectionByUid(int uid);        //根据uid查询出用户的收藏

    int addCollection(int aid,int uid);        //收藏专业信息,uid是需要补充的

    UCollection getCollectionByAidAndUid(int aid,int uid);

    int deleteOneCollectionByCid(int cid);
}
