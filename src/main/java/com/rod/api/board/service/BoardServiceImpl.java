package com.rod.api.board.service;


import com.rod.api.board.model.Board;
import com.rod.api.board.model.BoardDto;
import com.rod.api.board.repository.BoardRepository;
import com.rod.api.common.component.Messenger;
import com.rod.api.common.component.PageRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository repository;

    @Override
    public Messenger save(BoardDto boardDto) {
        entityToDto(Optional.of(repository.save(dtoToEntity(boardDto))))
        return new Messenger();
    }

    @Override
    public Messenger deleteById(Long id) {
        repository.deleteById(id);
        return new Messenger();
    }

    @Override
    public Messenger modify(BoardDto boardDto) {
        entityToDto(Optional.of(repository.save(dtoToEntity(boardDto))));
        return new Messenger();
    }

    @Override
    public List<BoardDto> findBoardsByBoardName(String boardName) {
        return repository.findByBoardName(boardName);
    }

    @Override
    public Optional<Board> findBoardsByBoardType(String boardType) {
        return Optional.of(entityToDto(repository.findByBoardType(boardType)));
    }

    @Override
    public List<BoardDto> findBoardsByRegisterDate(String registerDate) {
        return repository.findByRegisterDate();
    }


    @Override
    public List<BoardDto> findAll() {
        repository.findAll();
        return new ArrayList<>();
    }

    @Override
    public Optional<BoardDto> findById(Long id) {
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
