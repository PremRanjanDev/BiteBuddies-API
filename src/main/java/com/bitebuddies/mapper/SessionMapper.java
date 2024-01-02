package com.bitebuddies.mapper;

import com.bitebuddies.dao.SessionEntity;
import com.bitebuddies.dto.SessionDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {UserMapper.class, SessionUserMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SessionMapper {
    @Mapping(target = "initiatedBy.username", ignore = true)
    @Mapping(target = "initiatedBy.passwordHash", ignore = true)
    SessionDto map(SessionEntity entity);

    List<SessionDto> map(List<SessionEntity> entities);

    @Named("mapForCreate")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "initiatedBy", ignore = true)
    @Mapping(target = "pickedRestaurantId", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    SessionEntity mapForCreate(SessionDto req);

    @InheritConfiguration(name = "mapForCreate")
    @Mapping(target = "initiatedByUserId", ignore = true)
    void mapForUpdate(@MappingTarget SessionEntity entity, SessionDto req);
}
