package com.adhikari.futbol.services;

import com.adhikari.futbol.dtos.NewClubTeamRequest;
import com.adhikari.futbol.dtos.ResourceCreationResponse;
import com.adhikari.futbol.models.ClubTeam;
import com.adhikari.futbol.repos.ClubTeamRepository;
import com.adhikari.futbol.util.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubTeamService {

    private ClubTeamRepository clubTeamRepository;

    @Autowired
    public ClubTeamService(ClubTeamRepository clubTeamRepository){
        this.clubTeamRepository = clubTeamRepository;
    }


    public ResourceCreationResponse registerNewClubTeam(NewClubTeamRequest newClubTeamRequest){
        ClubTeam newClubTeam = newClubTeamRequest.extractClubTeamData();

        // todo validate team info
        if (!newClubTeam.getCountry().equals("England")){
            throw new InvalidRequestException("The club team must be based in England");
        }

        clubTeamRepository.save(newClubTeam);

        return new ResourceCreationResponse(newClubTeam.getId());
    }

}
