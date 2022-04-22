package com.example.lune.ServiceTest;

import com.example.lune.domain.User;
import com.example.lune.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void test(){
        System.out.println(userService.count());
        List<User> list= userService.allUser();
        for (User user : list) {
            System.out.println(user);
        }
        System.out.println(userService.FindUserById(1));
        System.out.println(userService.verifyPassword("chloe", "12345"));
        User user = new User();
        user.setUserId(4);
        user.setUserName("test_update");
        user.setUserPassword("testtest");
        user.setUserEmail("test@111.com");
        user.setUserAvatar("avatar.png");
        user.setUserRegistrationTime(new Date());
//        user.setUserAuthority(1);
//
//        userService.insertUserSelective(user);
        userService.insert(user);
//        userService.update(user);

//        userService.deleteById(4);
        System.out.println(userService.updateAvatar(user));//如果这个 user 不存在的话会返回 false
    }


}
