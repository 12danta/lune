package com.example.lune.mapper;

import com.example.lune.domain.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper {
    //添加新 admin
    Integer insert(Admin admin);
    //根据 id 删除 admin
    Integer deleteAdmin(Integer id);
    //查询所有的 admin
    List<Admin> allAdmin();
    //根据 id 返回 admin
    Admin findAdminById(Integer id);
    //验证账号密码
    Integer verifyPassword(String adminName,String adminPassword);

}
