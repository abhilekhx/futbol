package com.adhikari.futbol.repos;

import com.adhikari.futbol.models.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, String> {
//    Manager findManagerByClubTeamId(String id);
}
