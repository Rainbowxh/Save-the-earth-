package com.example.finalpaper.Mapper;

import com.example.finalpaper.Entity.room;
import com.example.finalpaper.FinalpaperApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.HashMap;
import java.util.stream.Collectors;

import static org.junit.Assert.*;



@RunWith(SpringRunner.class)
@SpringBootTest
public class roomMapperTest {
    @Autowired
    private  roomMapper roomMapper;

    @Test
    public void test() {
        System.out.println("This is a test");
        try {
            String findbyid = roomMapper.selectbyid("930304").toString();
            System.out.println(findbyid);
        }catch (Exception e ){
            System.out.println(e);
        }
    }

    @Test
    public void testInsert(){
        try {
            roomMapper.insertRoom(new room("333"));
            System.out.println("成功录入数据库");
        }catch (Exception e ){
            System.out.println("失败录入数据库");
            System.out.println(e.getClass());
        }
    }
    @Test
    public void testDelete(){
        try {
            roomMapper.deleteRoomById("A0930302");
            System.out.println("成功删除数据");
        }catch (Exception e ){
            System.out.println("失败录删除数据,数据依旧存在");
            System.out.println(e.getClass());
        }
    }

    @Test
    public void testUpdate(){
        try {
            roomMapper.updateRoomById(new room("333"));
            System.out.println("成功修改数据");
        }catch (Exception e ){
            System.out.println("失败司改数据");
            System.out.println(e);
        }
    }
}