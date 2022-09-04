package com.czf.graduation.mapper;

import com.czf.graduation.domain.School;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SchoolMapper {
    //根据pid查询出省份的所有大学
    List<School> selectCollegesByPid(int pid);

    //根据学校name查询出学校id
    int selectIdBySchoolName(String name);
}
