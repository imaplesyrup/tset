package com.jojo.dao;

import com.jojo.entity.MyUserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MyUserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MyUserInfo record);

    int insertSelective(MyUserInfo record);

    List<MyUserInfo> selectAllUser();

    List<MyUserInfo> selectByPrimaryKey(Integer id);

    List<MyUserInfo> selectByName(String name);

    int updateByPrimaryKeySelective(MyUserInfo record);

    int updateByPrimaryKey(MyUserInfo record);

    int delUserByid(@Param("ids") List<String> ids);
}