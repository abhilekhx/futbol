package com.adhikari.futbol.models;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;


@Entity
@Table(name="managers")
public class Manager {

    public Manager(){super();}

    public Manager(String id, String firstName, String lastName, Calendar dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    @Id
    private String id;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="dob", nullable = false)
    private Calendar dateOfBirth;

    @OneToOne
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
        return "Manager{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
