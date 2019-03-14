package com.example.finalpaper.Controller;

import com.example.finalpaper.Entity.building;
import com.example.finalpaper.Service.buildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "api")
@RestController
public class buildingController {

    @Autowired
    com.example.finalpaper.Service.buildingService buildingService;

    @RequestMapping(value = "/building",method = RequestMethod.GET)
    public String building() {
        return buildingService.getAll();
    }

    @RequestMapping(
            value = "/building",
            method = RequestMethod.GET ,
            params = "id")
    public @ResponseBody
    String buildingGetId(String id) {
        return buildingService.getById(id);
    }

    @RequestMapping(value = "/building/{id}",method = RequestMethod.GET)
    public @ResponseBody String buildingId(@PathVariable String id) {
        return buildingService.getById(id);
    }


    @RequestMapping(value = "/building" , method = RequestMethod.PUT)
    public @ResponseBody Integer buildingAdd( @Validated @RequestBody building buildingEntity){
        return buildingService.insertById(buildingEntity);
    }

    @RequestMapping(value = "/building/{id}" , method = RequestMethod.DELETE)
    public @ResponseBody Integer buildingDelete(@PathVariable String id){
        return buildingService.deleteById(id);
    }

    @RequestMapping(value = "/building" , method = RequestMethod.POST)
    public @ResponseBody Integer buildingChange( @Validated @RequestBody building buildingEntity){
        return buildingService.updateById(buildingEntity);
    }
}
