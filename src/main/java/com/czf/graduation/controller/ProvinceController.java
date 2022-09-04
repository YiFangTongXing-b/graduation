package com.czf.graduation.controller;

import com.czf.graduation.domain.Province;
import com.czf.graduation.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @RequestMapping("/getAllProvince")
    public List<Province> getAllProvince(){
        return provinceService.getAllProvince();
    }

    @RequestMapping("/getPidByName")
    public int getPidByName(String name){
        return provinceService.getPidByName(name);
    }
}
