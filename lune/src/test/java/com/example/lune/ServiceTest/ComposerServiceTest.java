package com.example.lune.ServiceTest;

import com.example.lune.domain.Composer;
import com.example.lune.service.ComposerService;
import com.sun.javaws.IconUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ComposerServiceTest {

    @Autowired
    ComposerService composerService;

    @Test
    void test(){

        Composer composer = new Composer();
//        composer.setComposerId(4);
        composer.setComposerName("test2222222222");
        composer.setComposerPeriods("Romantic period");
//        composer.setComposerPic("test.png");
        composer.setComposerIntroduction("testIntroduction");
        composer.setComposerLifeAndDeath("from to");
//        composerService.insert(composer);

//        composerService.deleteById(3);
//        List<Composer> list= composerService.allComposer();
//        for (Composer composer1 : list) {
//            System.out.println(composer1);
//        }
//        List list2 = composerService.composerOfPeriod("Romantic period");
//        for (Object o : list2) {
//            System.out.println(o);
//        }
//
//        System.out.println(composerService.composerOfId(4));
//        System.out.println(composerService.composerOfName("test"));

        composerService.insertSelective(composer);
        composerService.update(composer);
    }

}
