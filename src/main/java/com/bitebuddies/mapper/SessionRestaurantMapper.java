package com.bitebuddies.mapper;

import com.bitebuddies.dao.SessionRestaurantEntity;
import com.bitebuddies.dto.SessionRestaurantDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {SessionMapper.class, RestaurantMapper.class})
public interface SessionRestaurantMapper {
    @Mapping(target = "sessionId", source = "id.sessionId")
    @Mapping(target = "submittedByUserId", source = "submittedBy")
    SessionRestaurantDto map(SessionRestaurantEntity entity);

    List<SessionRestaurantDto> map(List<SessionRestaurantEntity> entities);
}
