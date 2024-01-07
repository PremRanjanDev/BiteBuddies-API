package com.bitebuddies.controller;

import com.bitebuddies.dto.RestaurantDto;
import com.bitebuddies.dto.SessionRestaurantDto;
import com.bitebuddies.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/all")
    public List<RestaurantDto> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public RestaurantDto getRestaurant(@PathVariable Long id) {
        return restaurantService.getRestaurant(id);
    }

    @PutMapping("/submit/{sessionId}")
    public SessionRestaurantDto addRestaurantToSession(@PathVariable Long sessionId, @RequestBody RestaurantDto restaurantDto, @RequestParam Long requesterId) {
        return restaurantService.addRestaurantToSession(sessionId, restaurantDto, requesterId);
    }
}
