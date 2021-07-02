package com.adhocsensei.ahsedgeservice.dao;

import com.adhocsensei.ahsedgeservice.dto.DAOUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<DAOUser, Long> {
    DAOUser findByUsername(String email);
}
