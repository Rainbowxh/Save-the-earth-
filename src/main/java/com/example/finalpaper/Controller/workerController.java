package com.example.finalpaper.Controller;

import com.example.finalpaper.Entity.user;
import com.example.finalpaper.Entity.worker;
import com.example.finalpaper.Service.workerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "api")
@RestController
public class workerController {

    @Autowired
    com.example.finalpaper.Service.workerService workerService;


    @RequestMapping(value = "/worker",method = RequestMethod.GET)
    public String workers() {
        return workerService.getAll();
    }

    @RequestMapping(
            value = "/worker",
            method = RequestMethod.GET ,
            params = "id")
    public @ResponseBody
    String workerGetId(String id) {
        return workerService.getById(id);
    }

    @RequestMapping(value = "/worker/{id}",method = RequestMethod.GET)
    public @ResponseBody String userId(@PathVariable String id) {
        return workerService.getById(id);
    }


    @RequestMapping(value = "/worker" , method = RequestMethod.PUT)
    public @ResponseBody Integer userAdd( @Validated @RequestBody worker userEntity){
        return workerService.insertById(userEntity);
    }

    @RequestMapping(value = "/worker/{id}" , method = RequestMethod.DELETE)
    public @ResponseBody Integer workerDelete(@PathVariable String id){
        return workerService.deleteById(id);
    }

    @RequestMapping(value = "/worker" , method = RequestMethod.POST)
    public @ResponseBody Integer workerChange( @Validated @RequestBody worker workerEntity){
        return workerService.updateById(workerEntity);
    }
}
