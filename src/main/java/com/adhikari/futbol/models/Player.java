package com.adhikari.futbol.models;

import javax.persistence.*;
import java.util.Calendar;


@Entity
@Table(name="players")
public class Player {

    public Player(){super();}

    public Player(String id, String firstName, String lastName, String position, Calendar dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.dateOfBirth = dateOfBirth;
    }

    @Id
    private String id;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="position", nullable = false)
    private String position;

    @Column(name="dob", nullable = false)
    private Calendar dateOfBirth;

    @ManyToOne
    @JoinColumn(name="club_id")
    private ClubTeam clubTeam;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public ClubTeam getClubTeam() {
        return clubTeam;
    }

    public void setClubTeam(ClubTeam clubTeam) {
        this.clubTeam = clubTeam;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
