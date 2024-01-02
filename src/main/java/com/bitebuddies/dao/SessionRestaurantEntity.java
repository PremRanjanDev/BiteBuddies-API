package com.bitebuddies.dao;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
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

    public SessionRestaurantEntity(Long sessionId, Long restaurantId, Long requesterId) {
        this.id = new SessionRestaurantId();
        this.id.setSessionId(sessionId);
        this.id.setRestaurantId(restaurantId);
        this.submittedBy = requesterId;
    }
}
