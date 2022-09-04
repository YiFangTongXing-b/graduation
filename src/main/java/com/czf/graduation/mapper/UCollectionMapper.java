package com.czf.graduation.mapper;

import com.czf.graduation.domain.UCollection;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UCollectionMapper {

    List<UCollection> selectCollectionByUid(int uid);

    int insertCollection(UCollection uCollection);

    UCollection selectCollectionByAidAndUid(@Param("aid") int aid,
                                            @Param("uid") int uid);

    int deleteCollectionByCid(int cid);
}
