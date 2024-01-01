package com.bitebuddies.mapper;

import com.bitebuddies.dao.SessionEntity;
import com.bitebuddies.dto.SessionDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;

@Mapper(componentModel = "spring",
        uses = {UserMapper.class, SessionUserMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SessionMapper {
    @Mapping(target = "initiatedBy.username", ignore = true)
    @Mapping(target = "initiatedBy.passwordHash", ignore = true)
    SessionDto map(SessionEntity entity);

    Collection<SessionDto> map(Collection<SessionEntity> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pickedRestaurantId", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    SessionEntity mapForCreate(SessionDto req);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "initiatedBy", ignore = true)
    void mapForUpdate(@MappingTarget SessionEntity entity, SessionDto req);
}
