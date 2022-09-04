package com.czf.graduation.service;

import com.czf.graduation.domain.School;

import java.util.List;

public interface SchoolService {

    List<School> getCollegesByPid(Integer pid);        //根据pid查询出学校信息

    int getIdBySchoolName(String name);              //根据name查询出id
}
