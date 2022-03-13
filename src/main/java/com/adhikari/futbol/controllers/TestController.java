package com.adhikari.futbol.controllers;

import com.adhikari.futbol.dtos.ResourceCreationResponse;
import com.adhikari.futbol.models.ClubTeam;
import com.adhikari.futbol.models.Manager;
import com.adhikari.futbol.repos.ClubTeamRepository;
import com.adhikari.futbol.repos.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;

@RestController // will expose Restful endpoints
@RequestMapping("/test") // will have "/test" extension
public class TestController {

    private ClubTeamRepository clubTeamRepository;

    // for IoC container
    @Autowired
    public TestController(ClubTeamRepository clubTeamRepository){
        this.clubTeamRepository = clubTeamRepository;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @GetMapping("/do-thing")
    public void doThing(){
        System.out.println("We did a thing");
    }

    @GetMapping
    public String test() {
        return"{\"endpoint\": \"/test\", \"status\": UP}";
    }

    // RequestMapping is the older method to achieve the same thing: method can be GET,POST,PUT,PATCH,DELETE
    @RequestMapping(method=RequestMethod.GET, value = "test2")
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

    // post method - save club team. this accepts a RequestBody and returns a response status with ResourceCreation DTO
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/test6", produces = "application/json", consumes = "application/json")
    public ResourceCreationResponse test6(@RequestBody ClubTeam clubTeamData){
        Calendar kloppDOB = Calendar.getInstance();
        kloppDOB.set(1967, 6, 16);
        Manager jurgenKlopp = new Manager("2", "Jurgen", "Klopp", kloppDOB);
        jurgenKlopp.setClubTeam(clubTeamData);

        clubTeamData.setPlayersInTeam(new ArrayList<>());
        clubTeamData.setManager(jurgenKlopp);

        clubTeamRepository.save(clubTeamData);

        return new ResourceCreationResponse(clubTeamData.getId());
    }


    // Grabbing request header values using a provided HttpServletRequest
    @GetMapping(value = "/test7", produces = "application/json")
    public HashMap<String, Object> test7(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        HashMap<String, Object> responseMap = new HashMap<>();
        responseMap.put("endpoint", "/test5");
        responseMap.put("status", "UP");
        responseMap.put("providedToken", token);

        return responseMap;
    }


    // check for authentication and inject token to HttpServletResponse if successful
    @PostMapping(value="/test8", produces = "application/json", consumes = "application/json")
    public void test8(@RequestBody HashMap<String, Object> credentials, HttpServletResponse response){
        if (credentials.get("username").equals("4bhilekh") && credentials.get("password").equals("p4$$word")){
            response.setHeader("Authorization", "some-token-value-here");
        } else {
            response.setStatus(401); // unauthorized
        }

    }

    // Using a ResponseEntity as a return to modify response values
    @GetMapping(value="/test9", produces = "application/json")
    public ResponseEntity<HashMap<String, Object>> test9(){
        HashMap<String,Object> responseMap = new HashMap<>();
        responseMap.put("endpoint","/test9");
        responseMap.put("status","UP");
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

}
