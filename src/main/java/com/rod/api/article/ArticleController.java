package com.rod.api.article;

import com.rod.api.common.component.MessengerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleServiceImpl service;
    @SuppressWarnings("unchecked")
    @GetMapping("/api/all-articles")
    public Map<?,?> findAll() throws SQLException {
        Map<String, Object> map = new HashMap<>();
//        @SuppressWarnings("unchecked")
//        List<Article> list = new ArrayList<>();
//
//        list = service.findAll();
//        list.forEach(System.out::println);
//        System.out.println("리스트 사이즈 : "+list.size());
//        map.put("result", list);
        return map;
    }

}
