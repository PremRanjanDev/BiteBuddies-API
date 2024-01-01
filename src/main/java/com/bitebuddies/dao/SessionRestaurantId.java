package com.bitebuddies.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class SessionRestaurantId implements Serializable {

    @Column(name = "session_id")
    private Long sessionId;

    @Column(name = "restaurant_id")
    private Long restaurantId;

}