package com.sam.minicinemaapi.mapper;

import com.sam.minicinemaapi.dto.request.UserRegistrationRequest;
import com.sam.minicinemaapi.dto.response.UserResponse;
import com.sam.minicinemaapi.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    User toEntity(UserRegistrationRequest request);

    UserResponse toResponse(User user);
}
