package com.adhikari.futbol.repos;

import com.adhikari.futbol.models.ClubTeam;
import com.adhikari.futbol.models.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player, String> {

    List<Player> getPlayersByPosition(String position);

    // jpql (use object and field names instead of table and column names)
    @Query("from Player p where p.clubTeam = ?1")
    List<Player> getPlayersByClubTeam(ClubTeam clubTeam);

//    @Query(value = "SELECT * from players WHERE first_name = ?1")
//    List<Player> getPlayersByFirstName(String firstName);

}
