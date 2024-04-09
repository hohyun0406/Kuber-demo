package com.rod.api.board;

import com.rod.api.board.model.BoardDto;
import com.rod.api.board.service.BoardServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequestMapping("/api/boards")
public class BoardController {
    private final BoardServiceImpl service;

//    @SuppressWarnings("unchecked")
    @GetMapping("/list")
    public ResponseEntity<List<BoardDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    
}
