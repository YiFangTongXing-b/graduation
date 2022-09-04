package com.czf.graduation.service.impl;

import com.czf.graduation.domain.Admission;
import com.czf.graduation.mapper.AdmissionMapper;
import com.czf.graduation.service.AdmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionServiceImpl implements AdmissionService {

    @Autowired
    private AdmissionMapper admissionMapper;

    @Override
    public int getSidByName(String schoolName) {
        return admissionMapper.selectSidByName(schoolName);
    }

    @Override
    public List<Admission> getAdmissionDetails(int sid, int year, int pid,String kind) {
        return admissionMapper.selectAdmissionDetails(sid,year,pid,kind);
    }

    @Override
    public Admission getAdmissionByAid(int aid) {
        return admissionMapper.selectAdmissionByAid(aid);
    }


}
