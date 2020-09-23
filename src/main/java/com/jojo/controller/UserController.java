package com.jojo.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jojo.biz.UserBiz;
import com.jojo.entity.LayUiTable;
import com.jojo.entity.MyUserInfo;
import com.jojo.util.MyConstants;
import com.jojo.util.TpSum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller   //使用@Controller标记的类就是一个SpringMVC Controller 对象，即一个控制器类
public class UserController {
    @Autowired
    private UserBiz userBizImpl;
    private static Integer rid;
    private static Integer sid;
    private static String sName;

    @RequestMapping("/toShowUserLayUi")
    public String toShowUserLayUi(){
        return "user/showUserLayUi";
    }

    @RequestMapping("/ShowUserLayUi")
    @ResponseBody
    public LayUiTable showUserLayUi(int page,int limit){
        //开始分页
        PageHelper.startPage(page,limit);
        List<MyUserInfo> userInfoList = userBizImpl.selectAllUser();
        //结束分页，封装好分页后的数据
        PageInfo<MyUserInfo> pageInfo = new PageInfo(userInfoList);
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        layUiTable.setCount(pageInfo.getTotal());
        layUiTable.setData(userInfoList);
        return layUiTable;
    }

    @RequestMapping("/saveUser")
    @ResponseBody
    public Object saveUser(MyUserInfo userInfo){
        TpSum ts = new TpSum();
        userInfo.setTp(ts.sum(userInfo.getWork1(),userInfo.getWork2()));
        int i = userBizImpl.insertSelective(userInfo);
        Map map = new HashMap<>();
        if(i>0){
            map.put("code", MyConstants.successCode);
            map.put("message",MyConstants.saveSuccessMsg);
        }else {
            map.put("code", MyConstants.failCode);
            map.put("message",MyConstants.saveFailMsg);
        }
        return map;
    }

    @RequestMapping("/delUser")
    @ResponseBody
    public Object delUser(@RequestParam(value = "ids") String ids){
        List<String> list =(List<String>) JSON.parse(ids);
        int i = userBizImpl.deleteByPrimaryKey(list);
        Map map = new HashMap<>();
        if(i>0){
            map.put("code", MyConstants.successCode);
            map.put("message",MyConstants.delSuccessMsg);
        }else {
            map.put("code", MyConstants.failCode);
            map.put("message",MyConstants.delFailMsg);
        }
        return map;
    }

    @RequestMapping("/editUser")
    @ResponseBody
    public Object editUser(MyUserInfo userInfo){
        userInfo.setRid(rid);
        TpSum ts = new TpSum();
        userInfo.setTp(ts.sum(userInfo.getWork1(),userInfo.getWork2()));
        int i = userBizImpl.updateByPrimaryKeySelective(userInfo);
        Map map = new HashMap<>();
        if(i>0){
            map.put("code", MyConstants.successCode);
            map.put("message",MyConstants.editSuccessMsg);
        }else {
            map.put("code", MyConstants.failCode);
            map.put("message",MyConstants.editFailMsg);
        }
        return map;
    }

    @RequestMapping("/seaUser")
    @ResponseBody
    public LayUiTable seaUser(){
        List<MyUserInfo> userInfoList =  userBizImpl.selectByPrimaryKey(sid);
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        layUiTable.setCount(1);
        layUiTable.setData(userInfoList);
        return layUiTable;
    }

    @RequestMapping("/seaNameUser")
    @ResponseBody
    public LayUiTable seaNameUser(){
        List<MyUserInfo> userInfoList =  userBizImpl.selectByName(sName);
        LayUiTable layUiTable = new LayUiTable();
        layUiTable.setCode(0);
        layUiTable.setMsg("返回消息");
        layUiTable.setCount(1);
        layUiTable.setData(userInfoList);
        return layUiTable;
    }

    @RequestMapping("/editRid")
    @ResponseBody
    public void editRid(MyUserInfo userInfo){
        rid = userInfo.getId();
    }

    @RequestMapping("/seaRid")
    @ResponseBody
    public Map seaRid(MyUserInfo userInfo){
        sid = userInfo.getId();
        Map map = new HashMap<>();
        map.put("code", MyConstants.successCode);
        map.put("message",MyConstants.saveSuccessMsg);
        return map;
    }

    @RequestMapping("/seaName")
    @ResponseBody
    public Map seaRName(MyUserInfo userInfo){
        sName = userInfo.getName();
        Map map = new HashMap<>();
        map.put("code", MyConstants.successCode);
        map.put("message",MyConstants.saveSuccessMsg);
        return map;
    }

}
