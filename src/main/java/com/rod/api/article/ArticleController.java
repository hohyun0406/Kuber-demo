package com.rod.api.article;

import com.rod.api.article.model.ArticleDto;
import com.rod.api.article.service.ArticleServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequestMapping("/api/articles")
public class ArticleController {
    private final ArticleServiceImpl service;
    @SuppressWarnings("unchecked")
    @GetMapping("/list")
    public ResponseEntity<List<ArticleDto>> findAll() {
//        Map<String, Object> map = new HashMap<>();
//        @SuppressWarnings("unchecked")
//        List<Article> list = new ArrayList<>();
//
//        list = service.findAll();
//        list.forEach(System.out::println);
//        System.out.println("리스트 사이즈 : "+list.size());
//        map.put("result", list);
        return ResponseEntity.ok(service.findAll());
    }

}
