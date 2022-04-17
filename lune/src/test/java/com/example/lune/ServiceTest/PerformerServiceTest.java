package com.example.lune.ServiceTest;

import com.example.lune.domain.Performer;
import com.example.lune.service.PerformerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PerformerServiceTest {

    @Autowired
    PerformerService performerService;

    @Test
    void test(){
        Performer performer = new Performer();
        performer.setPerformerId(8);
        performer.setPerformerName("test222");
        performer.setPerformerPic("test.png");
        performer.setPerformerIntroduce("introduction");
        performer.setPerformerType("violinist");

//        performerService.insert(performer);
//        System.out.println(performerService.performerOfId(1));
//        performerService.deleteById(7);
//        List<Performer> list = performerService.allPerformer();
//        for (Performer performer1 : list) {
//            System.out.println(performer1);
//        }
//        performerService.insertSelective(performer);
//        List<Performer> list1 = performerService.performerOfType("violinist");
//        for (Performer performer1 : list1) {
//            System.out.println(performer1);
//        }

        System.out.println(performerService.performerOfName("test111"));
        performerService.update(performer);


    }
}
