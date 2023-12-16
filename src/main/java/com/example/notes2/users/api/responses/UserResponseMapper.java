package com.example.notes2.users.api.responses;


import com.example.notes2.users.domain.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserResponseMapper {
    UserResponseMapper MAPPER = Mappers.getMapper( UserResponseMapper.class );

    UserResponse toResponse(User user);
}
