package com.rod.api.user;

import com.rod.api.common.component.MessengerVo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl service;
    private final UserRepository repo;


    @PostMapping("/api/login")
    public Map<String, ?> login(@RequestBody Map<?, ?> paramMap){
        Map<String, MessengerVo> map = new HashMap<>();
        String username = (String) paramMap.get("username");
        System.out.println("리퀘스트가 가져온 이름 : "+username);
        String password = (String) paramMap.get("password");
        System.out.println("리퀘스트가 가져온 비번 : "+password);
        User dbUser = repo.findByUsername(username).orElse(null);

        return map;
    }

    @PostMapping("/api/users")
    public Map<String, ?> join(@RequestBody Map<?, ?> paramMap){
        Map<String, MessengerVo> map = new HashMap<>();
        User newUser = repo.save(User.builder()
                .username((String) paramMap.get("username"))
                .password((String) paramMap.get("password"))
                .name((String) paramMap.get("name"))
                .phone((String) paramMap.get("phone"))
                .job((String) paramMap.get("job"))
                .build());
        System.out.println("DB 에 저장된 User 정보 : " + newUser);

        return map;
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/api/all-users")
    public List<?> findAll() throws SQLException {
//        Map<String, Object> map = new HashMap<>();
//        @SuppressWarnings("unchecked")
//        List<User> list = service.findAll();
//        list.forEach(System.out::println);
//        System.out.println("리스트 사이즈 : "+list.size());
//        map.put("result", list);
        return service.findAll();
    }

}
