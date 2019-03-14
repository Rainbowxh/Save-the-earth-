package com.example.finalpaper.Controller;

import com.example.finalpaper.Entity.user;
import com.example.finalpaper.Mapper.userMapper;
import com.example.finalpaper.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RequestMapping(value = "api")
@RestController
public class userController {

    @Autowired
    userService userService;
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String users() {
        return userService.getAll();
    }

    @RequestMapping(
            value = "/user",
            method = RequestMethod.GET ,
            params = "id")
    public @ResponseBody
    String userGetId(String id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public @ResponseBody String userId(@PathVariable String id) {
        return userService.getById(id);
    }


    @RequestMapping(value = "/user" , method = RequestMethod.PUT)
    public @ResponseBody Integer userAdd( @Validated @RequestBody user userEntity){
        return userService.insertById(userEntity);
    }

    @RequestMapping(value = "/user/{id}" , method = RequestMethod.DELETE)
    public @ResponseBody Integer userDelete(@PathVariable  String id){
        return userService.deleteById(id);
    }

    @RequestMapping(value = "/user" , method = RequestMethod.POST)
    public @ResponseBody Integer userChange( @Validated @RequestBody user userEntity){
        return userService.updateById(userEntity);
    }

}
