package com.example.lune.service.impl;

import com.example.lune.domain.Admin;
import com.example.lune.mapper.AdminMapper;
import com.example.lune.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Boolean insert(Admin admin) {
        return adminMapper.insert(admin) > 0;
    }

    @Override
    public Boolean deleteAdmin(Integer id) {
        return adminMapper.deleteAdmin(id) > 0;
    }

    @Override
    public List<Admin> allAdmin() {
        return adminMapper.allAdmin();
    }

    @Override
    public Admin findAdminById(Integer id) {
        return adminMapper.findAdminById(id);
    }

    @Override
    public Boolean verifyPassword(String adminName, String adminPassword) {
        return adminMapper.verifyPassword(adminName,adminPassword) > 0;
    }
}
