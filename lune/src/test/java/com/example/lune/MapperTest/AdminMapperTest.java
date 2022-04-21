package com.example.lune.MapperTest;

import com.example.lune.domain.Admin;
import com.example.lune.mapper.AdminMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class AdminMapperTest {

    @Autowired
    AdminMapper adminMapper;

    @Test
    void test(){
        Admin admin = new Admin();
        admin.setAdminName("test1");
        admin.setAdminPassword("password1");
//        adminMapper.insert(admin);
//        adminMapper.deleteAdmin(3);
        System.out.println(adminMapper.findAdminById(1));
        List<Admin> list = adminMapper.allAdmin();
        for (Admin admin1 : list) {
            System.out.println(admin1);
        }
        System.out.println("---------------================----------------");
        System.out.println(adminMapper.verifyPassword("admin", "12345"));
    }

}
