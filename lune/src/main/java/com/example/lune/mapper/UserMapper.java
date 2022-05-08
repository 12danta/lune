package com.example.lune.mapper;

import com.example.lune.domain.Admin;
import com.example.lune.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    //插入 user
    Integer insert(User user);
    //根据 id 删除 user
    Integer deleteById(Integer id);
    //更新 user
    Integer update(User user);
    //根据 id 查询 user
    User FindUserById(Integer id);
    //返回所有用户数据
    List<User> allUser();
    //根据账号获取密码
    String verifyPassword(String userName);
    //根据内容插入 user
    Integer insertUserSelective(User user);
    //更换头像
    Integer updateAvatar(User user);
    //查询用户总数
    Integer count();


}
