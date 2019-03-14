package com.example.finalpaper.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class apiController {

    @RequestMapping(value = "/api")
    public @ResponseBody String rules(){
        return "{"
                + "\"user\":\"" +"/api/user" + "\""
                + ", \"worker\":\"" + "/api/worker"+ "\""
                + ", \"parkingSpace\":\"" + "/api/parkingSpace" + "\""
                + ", \"facility\":\"" + "/api/facility" + "\""
                + ", \"record\":\"" + "/api/record" + "\""
                + ", \"room\":\"" + "/api/room" + "\""
                + ", \"property\":\"" + "/api/property" + "\""
                + ", \"rules\":\"" + "/api/rules" + "\""
                + "}";
    }
}
