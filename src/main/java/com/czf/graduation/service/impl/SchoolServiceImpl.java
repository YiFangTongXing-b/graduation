package com.czf.graduation.service.impl;

import com.czf.graduation.domain.School;

import com.czf.graduation.mapper.SchoolMapper;
import com.czf.graduation.service.SchoolService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {
    @Resource
    private SchoolMapper schoolMapper;

    @Override
    public List<School> getCollegesByPid(Integer pid) {
        return schoolMapper.selectCollegesByPid(pid);
    }

    @Override
    public int getIdBySchoolName(String name) {
        return schoolMapper.selectIdBySchoolName(name);
    }

}
