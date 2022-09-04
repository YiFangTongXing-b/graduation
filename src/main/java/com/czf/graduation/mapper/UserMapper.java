package com.czf.graduation.mapper;


import com.czf.graduation.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    Integer insertUser(User user);
    User findByUsername(String username);
    User selectUserByUid(int uid);

    Integer updatePassword(@Param("uid") int uid,
                           @Param("username") String username,
                           @Param("password") String password);
}
