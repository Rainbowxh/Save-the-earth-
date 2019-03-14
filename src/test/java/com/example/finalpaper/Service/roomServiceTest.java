package com.example.finalpaper.Service;

import org.apache.ibatis.session.SqlSessionException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class roomServiceTest {
    @Autowired
    private roomService roomService ;
    

    @Test
    public void getRoomAllTest() {
        System.out.println("test the all room");
        System.out.println(roomService.getAll());
    }
}