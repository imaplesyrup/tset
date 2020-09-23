package com.jojo.biz;

import com.jojo.entity.MyUserInfo;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserBiz {

    List<MyUserInfo> selectAllUser();

    int insertSelective(MyUserInfo record);

    int deleteByPrimaryKey(List<String> ids);

    int updateByPrimaryKeySelective(MyUserInfo record);

    List<MyUserInfo> selectByPrimaryKey(Integer id);

    List<MyUserInfo> selectByName(String name);

}
