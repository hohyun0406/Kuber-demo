package com.rod.api.user.service;


import com.rod.api.common.service.CommandService;
import com.rod.api.common.service.QueryService;
import com.rod.api.user.model.User;
import com.rod.api.user.model.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService extends CommandService<UserDto>, QueryService<UserDto> {
    default User dtoToEntity(UserDto dto){
        return User.builder().build();
    }

    default UserDto entityToDto(Optional<User> optional){
        return UserDto.builder().build();
    }
}