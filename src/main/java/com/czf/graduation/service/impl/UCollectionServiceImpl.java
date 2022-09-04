package com.czf.graduation.service.impl;

import com.czf.graduation.controller.exception.RepeatCollectException;
import com.czf.graduation.domain.Admission;
import com.czf.graduation.domain.UCollection;
import com.czf.graduation.mapper.UCollectionMapper;
import com.czf.graduation.service.AdmissionService;
import com.czf.graduation.service.ProvinceService;
import com.czf.graduation.service.UCollectionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UCollectionServiceImpl implements UCollectionService {
    @Autowired
    private UCollectionMapper uCollectionMapper;

    @Autowired
    private AdmissionService admissionService;

    @Autowired
    private ProvinceService provinceService;

    /*
    @Override
    public PageInfo<UCollection> getCollectionByUid(int uid, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<UCollection> list= uCollectionMapper.selectCollectionByUid(uid);
        return new PageInfo<>(list);
    }
    */

    @Override
    public List<UCollection> getCollectionByUid(int uid) {
        return uCollectionMapper.selectCollectionByUid(uid);
    }

    @Override
    public int addCollection(int aid,int uid) {
        UCollection uCollection = new UCollection();
        Admission admission = admissionService.getAdmissionByAid(aid);
        uCollection.setAid(aid);
        uCollection.setUid(uid);
        uCollection.setSchoolName(admission.getSchoolName());
        uCollection.setMajor(admission.getMajor());
        String province = provinceService.getNameByPid(admission.getPid());
        uCollection.setProvinceIndex(province);    //只有pid，需要provinceName
        uCollection.setYear(admission.getYear());
        uCollection.setLeastScore(admission.getLeastScore());
        uCollection.setLeastRank(admission.getLeastRank());
        uCollection.setAvgScore(admission.getAvgScore());
        uCollection.setHighScore(admission.getHighScore());
        uCollection.setNum(admission.getNum());
        uCollection.setKind(admission.getKind());
        int result = uCollectionMapper.insertCollection(uCollection);
        return result;

    }

    @Override
    public UCollection getCollectionByAidAndUid(int aid, int uid) {
        return uCollectionMapper.selectCollectionByAidAndUid(aid,uid);
    }

    @Override
    public int deleteOneCollectionByCid(int cid) {
        return uCollectionMapper.deleteCollectionByCid(cid);
    }
}
