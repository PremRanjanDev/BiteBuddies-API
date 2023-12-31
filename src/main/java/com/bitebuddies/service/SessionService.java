package com.bitebuddies.service;

import com.bitebuddies.dto.SessionDto;
import com.bitebuddies.mapper.SessionMapper;
import com.bitebuddies.repository.SessionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepo;

    @Autowired
    private SessionMapper sessionMapper;

    public List<SessionDto> getActiveSessions() {
        log.info("getActiveSessions");
        return sessionMapper.map(sessionRepo.findByActive(true));
    }

    public List<SessionDto> getAllSessions() {
        log.info("getAllSessions");
        return sessionMapper.map(sessionRepo.findAll());
    }

    public SessionDto getSession(Long id) {
        log.info("getSession : {}", id);
        return sessionMapper.map(sessionRepo.findById(id).get());
    }

    public SessionDto createSession(SessionDto req) {
        log.info("createSession : {}", req.getName());
        return sessionMapper.map(sessionRepo.save(sessionMapper.mapForCreate(req)));
    }

    public SessionDto updateSession(SessionDto req) {
        log.info("updateSession : {}", req.getId());
        var sessionInDb = sessionRepo.findById(req.getId()).get();
        sessionMapper.mapForUpdate(sessionInDb, req);
        return sessionMapper.map(sessionRepo.save(sessionInDb));
    }

    public void deleteSession(Long id) {
        log.info("deleteSession : {}", id);
        var sessionInDb = sessionRepo.findById(id).get();
        sessionRepo.delete(sessionInDb);
    }
}
