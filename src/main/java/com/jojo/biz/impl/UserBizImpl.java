package com.jojo.biz.impl;

import com.jojo.biz.UserBiz;
import com.jojo.dao.MyUserInfoMapper;
import com.jojo.entity.MyUserInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import java.util.List;

/*  请求->controller->service(biz)->dao->DB*/
@Service
public class UserBizImpl implements UserBiz {
    @Autowired
    private MyUserInfoMapper myUserInfoMapper;
    @Override
    public List<MyUserInfo> selectAllUser() {

        return myUserInfoMapper.selectAllUser();
    }
    @Override
    public int insertSelective(MyUserInfo record){
        return myUserInfoMapper.insertSelective(record);
    }

    @Override
    public int deleteByPrimaryKey(List<String> ids) {
        return myUserInfoMapper.delUserByid(ids);
    }

    @Override
    public int updateByPrimaryKeySelective(MyUserInfo record) {
        return myUserInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<MyUserInfo> selectByPrimaryKey(Integer id) {
        return myUserInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<MyUserInfo> selectByName(String name) {
        return myUserInfoMapper.selectByName(name);
    }


}
