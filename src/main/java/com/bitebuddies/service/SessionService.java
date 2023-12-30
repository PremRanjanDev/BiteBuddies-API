package com.bitebuddies.service;

import com.bitebuddies.dto.SessionDto;
import com.bitebuddies.mapper.SessionMapper;
import com.bitebuddies.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepo;

    @Autowired
    private SessionMapper sessionMapper;


    public List<SessionDto> getAllActiveSessions() {
        return sessionMapper.map(sessionRepo.findAll());
    }
}
