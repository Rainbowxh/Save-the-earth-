package com.example.finalpaper.Controller;

import com.example.finalpaper.Entity.parkingSpace;
import com.example.finalpaper.Service.parkingSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "api")
@RestController
public class parkingSpaceController {

    @Autowired
    parkingSpaceService parkingSpaceService;


    @RequestMapping(value = "/parkingSpace",method = RequestMethod.GET)
    public String parkingSpaces() {
        return parkingSpaceService.getAll();
    }

    @RequestMapping(
            value = "/parkingSpace",
            method = RequestMethod.GET ,
            params = "id")
    public @ResponseBody
    String parkingSpaceGetId(String id) {
        return parkingSpaceService.getById(id);
    }

    @RequestMapping(value = "/parkingSpace/{id}",method = RequestMethod.GET)
    public @ResponseBody String parkingSpaceId(@PathVariable String id) {
        return parkingSpaceService.getById(id);
    }

    @RequestMapping(value = "/parkingSpace/id",method = RequestMethod.GET)
    public @ResponseBody String getUseruuidNone() {
        return parkingSpaceService.getUseruuidNone();
    }

    @RequestMapping(value = "/parkingSpace" , method = RequestMethod.PUT)
    public @ResponseBody Integer parkingSpaceAdd( @Validated @RequestBody parkingSpace parkingSpaceEntity){
        return parkingSpaceService.insertById(parkingSpaceEntity);
    }

    @RequestMapping(value = "/parkingSpace/{id}" , method = RequestMethod.DELETE)
    public @ResponseBody Integer parkingSpaceDelete(@PathVariable String parkingSpaceId){
        return parkingSpaceService.deleteById(parkingSpaceId);
    }

    @RequestMapping(value = "/parkingSpace" , method = RequestMethod.POST)
    public @ResponseBody Integer parkingSpaceChange( @Validated @RequestBody parkingSpace parkingSpaceEntity){
        return parkingSpaceService.updateById(parkingSpaceEntity);
    }
}
