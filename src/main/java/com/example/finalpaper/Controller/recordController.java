package com.example.finalpaper.Controller;


import com.example.finalpaper.Entity.record;
import com.example.finalpaper.Service.recordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "api")
@RestController
public class recordController {
    @Autowired
    com.example.finalpaper.Service.recordService recordService;


    @RequestMapping(value = "/record",method = RequestMethod.GET)
    public String records() {
        return recordService.getAll();
    }

    @RequestMapping(
            value = "/record",
            method = RequestMethod.GET ,
            params = "id")
    public @ResponseBody
    String recordGetId(String id) {
        return recordService.getById(id);
    }

    @RequestMapping(value = "/record/{id}",method = RequestMethod.GET)
    public @ResponseBody String recordId(@PathVariable String id) {
        return recordService.getById(id);
    }


    @RequestMapping(value = "/record" , method = RequestMethod.PUT)
    public @ResponseBody Integer recordAdd( @Validated @RequestBody record recordEntity){
        return recordService.insertById(recordEntity);
    }

    @RequestMapping(value = "/record/{id}" , method = RequestMethod.DELETE)
    public @ResponseBody Integer recordDelete(@PathVariable String recordId){
        return recordService.deleteById(recordId);
    }

    @RequestMapping(value = "/record" , method = RequestMethod.POST)
    public @ResponseBody Integer recordChange( @Validated @RequestBody record recordEntity){
        return recordService.updateById(recordEntity);
    }
}
