package com.bitebuddies.mapper;

import com.bitebuddies.dao.SessionEntity;
import com.bitebuddies.dto.SessionDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SessionMapper {
    SessionDto map(SessionEntity entity);
    List<SessionDto> map(List<SessionEntity> entities);

    @Mapping(target = "id", ignore = true)
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
