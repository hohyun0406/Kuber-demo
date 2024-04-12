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
        repository.save(dtoToEntity(userDto));
        return Messenger.builder().message(repository.findById(userDto.getId()).isPresent() ? "SUCCESS" : "FAILURE").build();
    }

    @Override
    public Messenger deleteById(Long id) {
        repository.deleteById(id);
        return Messenger.builder().message(repository.findById(id).isPresent() ? "FAILURE" : "SUCCESS").build(); //값이 없어야 성공
    }

    @Override
    public Messenger modify(UserDto userDto) {
        return Messenger.builder().message((repository.save(dtoToEntity(userDto)) instanceof User) ? "SUCCESS" : "FAILURE").build(); //아직 무조건 성공만
    }

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

    public Messenger login(UserDto userDto) {
        return null;
    }
}