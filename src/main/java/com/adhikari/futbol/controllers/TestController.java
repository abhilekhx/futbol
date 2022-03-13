package com.adhikari.futbol.controllers;

import com.adhikari.futbol.models.ClubTeam;
import com.adhikari.futbol.models.Manager;
import com.adhikari.futbol.models.Player;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

@RestController // will expose Restful endpoints
@RequestMapping("/test") // will have "/test" extension
public class TestController {


    @GetMapping
    public String test() {
        return"{\"endpoint\": \"/test\", \"status\": UP}";
    }

    @GetMapping(value = "test2")
    public String test2() {
        return"{\"endpoint\": \"/test2\", \"status\": UP}";
    }

    // takes in request parameters
    @GetMapping(value = "test3", produces = "application/json")
    public HashMap<String, Object> test3(@RequestParam String username, @RequestParam("email") String someEmail) {

        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("endpoint", "/test3");
        responseMap.put("status", "UP");
        responseMap.put("providedValues", Arrays.asList(username, someEmail));

        return responseMap;
    }

    // Grabbing request header values
    @GetMapping(value = "test4", produces = "application/json")
    public HashMap<String, Object> test4(@RequestHeader(name ="Authorization", required = false) String token) {

        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("endpoint", "/test4");
        responseMap.put("status", "UP");
        responseMap.put("providedToken", token);

        return responseMap;
    }


    // grabbing path parameter values
    @GetMapping(value = "/test5/{something}/{anotherSomething}", produces = "application/json")
    public HashMap<String, Object> test5(@PathVariable String something, @PathVariable String anotherSomething) {

        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("endpoint", "/test5");
        responseMap.put("status", "UP");
        responseMap.put("pathParameter1", something);
        responseMap.put("pathParameter2", anotherSomething);

        return responseMap;
    }

    // post method. this accepts a RequestBody and returns a response status
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/test6", produces = "application/json", consumes = "application/json")
    public HashMap<String, Object> test6(@RequestBody ClubTeam clubTeam){
        clubTeam.setManager(new Manager());
        clubTeam.setPlayersInTeam(new ArrayList<>());
        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("endpoint", "/test6");
        responseMap.put("status", "UP");
        responseMap.put("providedPlayerData", clubTeam);

        return responseMap;
    }

}
