package com.czf.graduation.mapper;

import com.czf.graduation.domain.Province;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProvinceMapper {

    List<Province> selectAllProvince();

    int selectPidByName(String name);        //学校名-》 id

    String selectNameByPid(int pid);
}
