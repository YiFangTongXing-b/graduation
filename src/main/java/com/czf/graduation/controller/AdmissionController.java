package com.czf.graduation.controller;

import com.czf.graduation.domain.Admission;
import com.czf.graduation.service.AdmissionService;
import com.czf.graduation.service.AdmissionService;
import com.czf.graduation.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admission")
public class AdmissionController {

    @Autowired
    private AdmissionService admissionService;

    @Autowired
    private ProvinceService provinceService;

    @RequestMapping("/getSidByName")
    public int getSidByName(String schoolName){
        return admissionService.getSidByName(schoolName);
    }

    @RequestMapping("/getAdmissionDetail")
    public List<Admission> getAdmissionDetail(int sid,int year,int pid,String kind){
        return admissionService.getAdmissionDetails(sid,year,pid,kind);
    }

    @RequestMapping("/getAdmission")
    public List<Admission> getAdmissionsBySid(String schoolName,int year,String province,String kind){
        int sid = admissionService.getSidByName(schoolName);
        int pid = provinceService.getPidByName(province);
        return getAdmissionDetail(sid,year,pid,kind);
    }


}
