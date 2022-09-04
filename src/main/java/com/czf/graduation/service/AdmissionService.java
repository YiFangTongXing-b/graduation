package com.czf.graduation.service;


import com.czf.graduation.domain.Admission;

import java.util.List;

public interface AdmissionService {

    int getSidByName(String schoolName);

    List<Admission> getAdmissionDetails(int sid,int year,int pid,String kind);

    Admission getAdmissionByAid(int aid);
}
