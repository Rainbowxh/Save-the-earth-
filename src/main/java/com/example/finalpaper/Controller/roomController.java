package com.example.finalpaper.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.finalpaper.Service.roomService;
import com.example.finalpaper.Entity.room;

import javax.validation.constraints.NotBlank;


@RequestMapping(value = "api")
@RestController
public class roomController {

    @Autowired
    roomService roomService;


    @RequestMapping(value = "/room",method = RequestMethod.GET)
    public String rooms() {
        return roomService.getAll();
    }

    @RequestMapping(
            value = "/room",
            method = RequestMethod.GET ,
            params = "id")
    public @ResponseBody String roomGetId( String id) {
        return roomService.getById(id);
    }

    @RequestMapping(value = "/room/{id}",method = RequestMethod.GET)
    public @ResponseBody String roomId(@PathVariable String id) {
            return roomService.getById(id);
    }


    @RequestMapping(value = "/room" , method = RequestMethod.PUT)
    public @ResponseBody Integer roomAdd( @Validated @RequestBody room roomEntity){
        return roomService.insertById(roomEntity);
    }

    @RequestMapping(value = "/room/{id}" , method = RequestMethod.DELETE)
    public @ResponseBody Integer roomDelete(@PathVariable String id){
        return roomService.deleteById(id);
    }

    @RequestMapping(value = "/room" , method = RequestMethod.POST)
    public @ResponseBody Integer roomChange( @Validated @RequestBody room roomEntity){
        return roomService.updateById(roomEntity);
    }

}
