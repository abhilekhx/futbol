package com.adhikari.futbol.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name="club_teams")
public class ClubTeam{

    public ClubTeam(){super();};

    public ClubTeam(String id, String clubName, String city, String country, String stadium) {
        this.id = id;
        this.clubName = clubName;
        this.city = city;
        this.country = country;
        this.stadium = stadium;

        manager = new Manager();
        playersInTeam = new ArrayList<>();
    }

    @Id
    private String id;

    @Column(name="club_name",nullable = false)
    private String clubName;

    @Column(name="city", nullable = false)
    private String city;

    @Column(name="country", nullable = false)
    private String country;

    @Column(name="stadium", nullable = false)
    private String stadium;

    @OneToOne(
            mappedBy = "clubTeam",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL // when a ClubTeam is saved, save all Players in this list (if any exist)
            )
    private Manager manager;

    @OneToMany(
            mappedBy = "clubTeam",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL // when a ClubTeam is saved, save all Players in this list (if any exist)
    )
    private List<Player> playersInTeam;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public List<Player> getPlayersInTeam() {
        return playersInTeam;
    }

    public void setPlayersInTeam(List<Player> playersInTeam) {
        this.playersInTeam = playersInTeam;
    }

    public void addPlayersToClubTeam(Player... players){
        System.out.println("Players In Team: "+playersInTeam);
        playersInTeam.addAll(Arrays.asList(players));
    }

    @Override
    public String toString() {
        return "ClubTeam{" +
                "id='" + id + '\'' +
                ", clubName='" + clubName + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", stadium='" + stadium + '\'' +
                ", manager=" + manager +
                ", players=" + playersInTeam +
                '}';
    }
}