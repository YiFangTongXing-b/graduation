package com.czf.graduation.service;

import com.czf.graduation.domain.Province;

import java.util.List;

public interface ProvinceService {

    List<Province> getAllProvince();

    Integer getPidByName(String name);

    String getNameByPid(int pid);
}
