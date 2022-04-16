package com.example.lune.ServiceTest;

import com.example.lune.domain.Admin;
import com.example.lune.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AdminServiceTest {

    @Autowired
    AdminService adminService;

    @Test
    void test(){
        List<Admin> list = adminService.allAdmin();
        for (Admin admin : list) {
            System.out.println(admin);
        }

        Admin admin = new Admin();
        admin.setAdminName("test1");
        admin.setAdminPassword("password1");
//        adminService.insert(admin);
        adminService.deleteAdmin(4);
        System.out.println(adminService.findAdminById(1));

        System.out.println("---------------================----------------");
        System.out.println(adminService.verifyPassword("admin", "123456"));
    }
}
