package com.czf.graduation.mapper;

import com.czf.graduation.domain.Admission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdmissionMapper {

    int selectSidByName(String schoolName);     //根据学校name返回sid

    List<Admission> selectAdmissionDetails(@Param("sid") int sid,
                                           @Param("year") int year,
                                           @Param("pid") int pid,
                                           @Param("kind") String kind);   //学校id，年份，省份id , 文理科

    Admission selectAdmissionByAid(int aid);            //根据aid拿到单条信息
}
