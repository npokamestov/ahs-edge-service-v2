package com.adhocsensei.ahsedgeservice.dao;

import com.adhocsensei.ahsedgeservice.dto.Authority;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Table;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {}
