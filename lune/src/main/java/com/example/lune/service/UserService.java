package com.example.lune.service;

import com.example.lune.domain.User;

import java.util.List;

public interface UserService {

    //插入 user
    Boolean insert(User user);
    //根据 id 删除 user
    Boolean deleteById(Integer id);
    //更新 user
    Boolean update(User user);
    //根据 id 查询 user
    User FindUserById(Integer id);
    //返回所有用户数据
    List<User> allUser();
    //验证账号密码
    String verifyPassword(String userName);
    //根据内容插入 user
    Boolean insertUserSelective(User user);
    //更换头像
    Boolean updateAvatar(User user);
    //查询用户总数
    Integer count();
}
