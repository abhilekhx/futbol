package com.adhikari.futbol.dtos;

import com.adhikari.futbol.models.ClubTeam;

import java.util.UUID;

public class NewClubTeamRequest {

    private String id;

    private String clubName;

    private String city;

    private String country;

    private String stadium;

    public NewClubTeamRequest(){}

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

    public ClubTeam extractClubTeamData(){
        ClubTeam clubTeamData = new ClubTeam();
        clubTeamData.setId(UUID.randomUUID().toString());
        clubTeamData.setClubName(clubName);
        clubTeamData.setCity(city);
        clubTeamData.setCountry(country);
        clubTeamData.setStadium(stadium);

        return clubTeamData;
    }

    @Override
    public String toString() {
        return "NewClubTeamRequest{" +
                "id='" + id + '\'' +
                ", clubName='" + clubName + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", stadium='" + stadium + '\'' +
                '}';
    }
}
