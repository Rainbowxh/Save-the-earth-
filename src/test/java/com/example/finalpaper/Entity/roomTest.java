package com.example.finalpaper.Entity;

import org.junit.Before;
import org.junit.Test;

import javax.validation.Valid;

import static org.junit.Assert.*;

public class roomTest {
    @Valid
    private room newRoom = new room();

    @Test
    public void testtoString() {
        newRoom.setLatitude((float) 2.222);
        newRoom.setLongitude((float) 2.222);
        newRoom.setDescribtion(null);
        newRoom.setUseruuid("1324");
        System.out.println(newRoom.toString());
    }
}