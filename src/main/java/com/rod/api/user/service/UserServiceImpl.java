package com.rod.api.user.service;


import com.rod.api.common.component.Messenger;
import com.rod.api.common.component.PageRequestVo;
import com.rod.api.user.model.User;
import com.rod.api.user.model.UserDto;
import com.rod.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public Messenger save(UserDto userDto) {
        entityToDto(repository.save(dtoToEntity(userDto)));
        return new Messenger();
    }

//    @Override
//    public UserDto save(UserDto userDto) {
//        return entityToDto(Optional.of(repository.save(dtoToEntity(userDto))));
//    }

    @Override
    public Messenger deleteById(Long id) {
        repository.deleteById(id);
        return Messenger.builder().message("Success").build();
    }

    @Override
    public Messenger modify(UserDto userDto) {
        return null;
    }

//    @Override
//    public List<UserDto> findUsersByName(String name) {
//        return null;
//    }
//
//    @Override
//    public List<UserDto> findUsersByJob(String job) {
//        return null;
//    }
//
//    @Override
//    public Optional<User> findUsersByUsername(String username) {
//        return repository.findByUsername(username);
//    }


    @Override
    public List<UserDto> findAll() {
        return repository.findAll().stream().map(this::entityToDto).collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return repository.findById(id).map(this::entityToDto);
    }

    @Override
    public long count() {
        return repository.count();
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

}