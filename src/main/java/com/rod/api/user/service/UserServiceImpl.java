package com.rod.api.user.service;


import com.rod.api.common.component.PageRequestVo;
import com.rod.api.user.model.UserDto;
import com.rod.api.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public UserDto save(UserDto articleDto) {
        return entityToDto(Optional.of(repository.save(dtoToEntity(articleDto))));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<UserDto> findAll(PageRequestVo vo) {
        return null;
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return Optional.of(entityToDto(repository.findById(id)));
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