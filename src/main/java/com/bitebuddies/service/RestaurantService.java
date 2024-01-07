package com.bitebuddies.service;

import com.bitebuddies.dao.SessionRestaurantEntity;
import com.bitebuddies.dto.RestaurantDto;
import com.bitebuddies.dto.SessionRestaurantDto;
import com.bitebuddies.exception.InvalidRequestException;
import com.bitebuddies.exception.ResourceNotFoundException;
import com.bitebuddies.mapper.RestaurantMapper;
import com.bitebuddies.mapper.SessionRestaurantMapper;
import com.bitebuddies.model.InviteStatus;
import com.bitebuddies.repository.RestaurantRepository;
import com.bitebuddies.repository.SessionRestaurantRepository;
import com.bitebuddies.repository.SessionUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepo;

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Autowired
    private SessionUserRepository sessionUserRepo;

    @Autowired
    private SessionRestaurantRepository sessionRestaurantRepo;

    @Autowired
    private SessionRestaurantMapper sessionRestaurantMapper;

    public List<RestaurantDto> getAllRestaurants() {
        log.info("getAllRestaurants");
        return restaurantMapper.map(restaurantRepo.findAll());
    }

    public RestaurantDto getRestaurant(Long id) {
        log.info("getRestaurant : {}", id);
        return restaurantMapper.map(restaurantRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Restaurant not found")));
    }

    public SessionRestaurantDto addRestaurantToSession(Long sessionId, RestaurantDto restaurantDto, Long requesterId) {
        log.info("addRestaurantToSession: sessionId {}", sessionId);
        var invite = sessionUserRepo.findBySessionIdAndUserId(sessionId, requesterId).orElseThrow(() -> new ResourceNotFoundException("User not invited for the session"));
        if (!InviteStatus.joined.equals(invite.getStatus())) {
            throw new InvalidRequestException("User not joined for the session");
        }
        var restaurant = restaurantDto.getId() == null
                ? restaurantRepo.save(restaurantMapper.mapForCreate(restaurantDto))
                : restaurantRepo.findById(restaurantDto.getId()).get();

        var sessionRestaurant = sessionRestaurantRepo.save(new SessionRestaurantEntity(sessionId, restaurant.getId(), requesterId));

        log.info("Restaurant added : {}", restaurant.getId());
        return sessionRestaurantMapper.map(sessionRestaurant);
    }
}
