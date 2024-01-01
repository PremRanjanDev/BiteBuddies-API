package com.bitebuddies.dao;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "session_restaurants")
public class SessionRestaurantEntity {

    @EmbeddedId
    private SessionRestaurantId id;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false, insertable = false, updatable = false)
    private SessionEntity session;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false, insertable = false, updatable = false)
    private RestaurantEntity restaurant;

    private Long submittedBy;
}
