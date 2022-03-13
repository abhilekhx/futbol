package com.adhikari.futbol.repos;

import com.adhikari.futbol.models.ClubTeam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubTeamRepository extends CrudRepository<ClubTeam, String> {
//    ClubTeam findClubTeamByPlayersId(String id);
//    ClubTeam findClubTeamByManagerId(String id);
}
