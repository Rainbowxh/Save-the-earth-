package com.example.finalpaper.Mapper;

import com.example.finalpaper.Entity.facility;
import com.example.finalpaper.Entity.worker;
import lombok.NonNull;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.plugin.navig.motif.Worker;

import javax.validation.constraints.NotBlank;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperTest {
    @Autowired
    facilityMapper facilityMapper;

    @Autowired
    parkingSpaceMapper parkingSpaceMapper;

    @Autowired
    recordMapper recordMapper;

    @Autowired
    roomMapper roomMapper;

    @Autowired
    userMapper userMapper;

    @Autowired
    workerMapper workerMapper;

    @Test
    public void facilityTest() {
        String all =  facilityMapper.selectAll().toString();
        System.out.println("all Result is " + all);
//        String selectbyid = facilityMapper.selectbyid("Room123").toString();
//        System.out.println(selectbyid);
    }

    @Test
    public void roomTest() {
        String all = userMapper.selectAll().toString();
        System.out.println("user Result is "+ all);
    }

    @Test
    public void workerTest() {
        int all = workerMapper.insertRecordById(new worker("222","elicxh"));
        System.out.println("user Result is "+ all);
    }
    @Test
    public void test() {
        System.out.println("This is a test");
        try {
            String findbyid = userMapper.selectAll().toString();
            System.out.println(findbyid);
        }catch (Exception e ){
            System.out.println(e);
        }
    }
}
