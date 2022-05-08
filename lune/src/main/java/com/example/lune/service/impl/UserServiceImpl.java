package com.example.lune.service.impl;

import com.example.lune.domain.User;
import com.example.lune.mapper.UserMapper;
import com.example.lune.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Boolean insert(User user) {
        return userMapper.insert(user) > 0;
    }

    @Override
    public Boolean deleteById(Integer id) {
        return userMapper.deleteById(id) > 0;
    }

    @Override
    public Boolean update(User user) {
        return userMapper.update(user) > 0;
    }

    @Override
    public User FindUserById(Integer id) {
        return userMapper.FindUserById(id);
    }

    @Override
    public List<User> allUser() {
        return userMapper.allUser();
    }

    @Override
    public String verifyPassword(String userName) {
        return userMapper.verifyPassword(userName) ;
    }

    @Override
    public Boolean insertUserSelective(User user) {
        return userMapper.insertUserSelective(user) > 0;
    }

    @Override
    public Boolean updateAvatar(User user) {
        return userMapper.updateAvatar(user) > 0;
    }

    @Override
    public Integer count() {
        return userMapper.count();
    }
}
