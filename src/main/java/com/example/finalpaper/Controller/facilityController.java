
package com.example.finalpaper.Controller;


import com.example.finalpaper.Entity.facility;
import com.example.finalpaper.Service.facilityService;
import com.example.finalpaper.Service.facilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "api")
@RestController
public class facilityController {

    @Autowired
    facilityService facilityService;

    @RequestMapping(value = "/facility",method = RequestMethod.GET)
    public String facility() {
        return facilityService.getAll();
    }

    @RequestMapping(
            value = "/facility",
            method = RequestMethod.GET ,
            params = "id")
    public @ResponseBody
    String facilityGetId(String id) {
        return facilityService.getById(id);
    }

    @RequestMapping(value = "/facility/{id}",method = RequestMethod.GET)
    public @ResponseBody String facilityId(@PathVariable String id) {
        return facilityService.getById(id);
    }


    @RequestMapping(value = "/facility" , method = RequestMethod.PUT)
    public @ResponseBody Integer facilityAdd( @Validated @RequestBody facility facilityEntity){
        return facilityService.insertById(facilityEntity);
    }

    @RequestMapping(value = "/facility/{id}" , method = RequestMethod.DELETE)
    public @ResponseBody Integer facilityDelete(@PathVariable String facilityId){
        return facilityService.deleteById(facilityId);
    }

    @RequestMapping(value = "/facility" , method = RequestMethod.POST)
    public @ResponseBody Integer facilityChange( @Validated @RequestBody facility facilityEntity){
        return facilityService.updateById(facilityEntity);
    }
}
