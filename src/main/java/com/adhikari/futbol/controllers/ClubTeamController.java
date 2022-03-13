package com.adhikari.futbol.controllers;

import com.adhikari.futbol.dtos.NewClubTeamRequest;
import com.adhikari.futbol.dtos.ResourceCreationResponse;
import com.adhikari.futbol.models.ClubTeam;
import com.adhikari.futbol.services.ClubTeamService;
import com.adhikari.futbol.util.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestController
@RequestMapping("clubTeams")
public class ClubTeamController {

    private ClubTeamService clubTeamService;

    @Autowired
    public ClubTeamController(ClubTeamService clubTeamService){
        this.clubTeamService = clubTeamService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces="application/json", consumes="application/json")
    public ResourceCreationResponse registerClubTeam(@RequestBody NewClubTeamRequest newClubTeamRequest){

        return clubTeamService.registerNewClubTeam(newClubTeamRequest);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler // handle exceptions in controller
    public HashMap<String,Object> handleInvalidRequest(InvalidRequestException e){
        HashMap<String, Object> responseBody = new HashMap<>();
        responseBody.put("status", "400");
        responseBody.put("message", e.getMessage());
        responseBody.put("timestamp", LocalDateTime.now());

        return responseBody;
    }
}
