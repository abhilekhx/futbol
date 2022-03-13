package com.adhikari.futbol.util;

import com.adhikari.futbol.models.ClubTeam;
import com.adhikari.futbol.models.Manager;
import com.adhikari.futbol.models.Player;
import com.adhikari.futbol.repos.ClubTeamRepository;
import com.adhikari.futbol.repos.ManagerRepository;
import com.adhikari.futbol.repos.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Component
public class DummyDataInserter implements CommandLineRunner {

    private final PlayerRepository playerRepository;
    private final ManagerRepository managerRepository;
    private final ClubTeamRepository clubTeamRepository;

    @Autowired
    public DummyDataInserter(PlayerRepository playerRepository, ManagerRepository managerRepository, ClubTeamRepository clubTeamRepository){

        this.playerRepository = playerRepository;
        this.managerRepository = managerRepository;
        this.clubTeamRepository = clubTeamRepository;

    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // Write persistence logic here for dummy data

        ClubTeam arsenal = new ClubTeam(UUID.randomUUID().toString(), "Arsenal FC", "London", "England", "Emirates");

        Calendar sakaDOB = Calendar.getInstance();
        sakaDOB.set(2001,9,5);
        Player bukayoSaka = new Player("7", "Bukayo", "Saka", "Winger", sakaDOB);

        Calendar lacazetteDOB = Calendar.getInstance();
        sakaDOB.set(1991,5,28);
        Player alexLacazette = new Player("9", "Alexandre", "Lacazette", "Striker", lacazetteDOB);

        Calendar artetaDOB = Calendar.getInstance();
        artetaDOB.set(1982,3,26);
        Manager mikelArteta = new Manager("1", "Mikel", "Arteta", artetaDOB);

        bukayoSaka.setClubTeam(arsenal);
        alexLacazette.setClubTeam(arsenal);

        mikelArteta.setClubTeam(arsenal);


        arsenal.addPlayersToClubTeam(bukayoSaka, alexLacazette);
        arsenal.setManager(mikelArteta);
        clubTeamRepository.save(arsenal);

        System.out.println(playerRepository.getPlayersByClubTeam(arsenal));

    }
}
