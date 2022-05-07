package com.example.lune;

import com.example.lune.domain.Admin;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.engine.Constants;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LuneApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(System.getProperty("user.dir"));//当前工作的目录
        System.out.println(System.getProperty("file.separator"));//当前工作环境下的文件分割符，windows下是\,unix环境下是/
        Admin admin = new Admin();
        admin.setAdminName(null);


    }


}
