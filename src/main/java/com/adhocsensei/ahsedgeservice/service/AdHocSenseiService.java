package com.adhocsensei.ahsedgeservice.service;

import com.adhocsensei.ahsedgeservice.dao.AuthorityRepository;
import com.adhocsensei.ahsedgeservice.dao.UserRepository;
import com.adhocsensei.ahsedgeservice.dto.Authority;
import com.adhocsensei.ahsedgeservice.util.feign.CourseApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RefreshScope
public class AdHocSenseiService {

    private AuthorityRepository authRepo;
    private UserRepository userRepo;
    private CourseApiClient courseClient;
//    private SenseiApiClient senseiClient;
//    private StudentApiClient studentClient;

    @Autowired
    public AdHocSenseiService(AuthorityRepository authRepo, UserRepository userRepo, CourseApiClient courseClient) {
        this.authRepo = authRepo;
        this.userRepo = userRepo;
        this.courseClient = courseClient;
//        this.senseiClient = senseiClient;
//        this.studentClient =studentClient;
    }

// for registering, if the courses userId == to the id of the user who is registering, then you cannot register
}
