package com.example.lune.service;

import com.example.lune.domain.Admin;

import java.util.List;

public interface AdminService {
    //添加新 admin
    Boolean insert(Admin admin);
    //根据 id 删除 admin
    Boolean deleteAdmin(Integer id);
    //查询所有的 admin
    List<Admin> allAdmin();
    //根据 id 返回 admin
    Admin findAdminById(Integer id);
    //验证账号密码
    Boolean verifyPassword(String adminName,String adminPassword);
}
