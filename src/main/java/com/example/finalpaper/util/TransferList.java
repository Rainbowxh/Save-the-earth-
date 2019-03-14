package com.example.finalpaper.util;

import com.example.finalpaper.Entity.room;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
public   class TransferList{

    public static String transDate(Date time){
        if(time == null){
            return "";
        }
        else{
            SimpleDateFormat myFmt2=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
            return myFmt2.format(time);
        }
    }

}
