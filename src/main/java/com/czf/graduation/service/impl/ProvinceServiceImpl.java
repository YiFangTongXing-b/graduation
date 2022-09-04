package com.czf.graduation.service.impl;

import com.czf.graduation.domain.Province;
import com.czf.graduation.mapper.ProvinceMapper;
import com.czf.graduation.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {

    @Autowired
    private ProvinceMapper provinceMapper;

    @Override
    public List<Province> getAllProvince() {
        return provinceMapper.selectAllProvince();
    }

    @Override
    public Integer getPidByName(String name) {
        return provinceMapper.selectPidByName(name);
    }

    @Override
    public String getNameByPid(int pid) {
        return provinceMapper.selectNameByPid(pid);
    }
}
