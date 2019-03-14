package com.example.finalpaper;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDb {
    String url="jdbc:mysql://localhost:3306/FinalPaper";
    String name = "root";
    String pwd = "56371209";

    @Test
    public void closeAll() throws Exception{
        Connection conn = DriverManager.getConnection(url,name,pwd);
        System.out.println(conn);
    }
}
