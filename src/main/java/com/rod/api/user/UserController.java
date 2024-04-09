package com.rod.api.user;

import com.rod.api.common.component.Messenger;
import com.rod.api.user.model.User;
import com.rod.api.user.model.UserDto;
import com.rod.api.user.repository.UserRepository;
import com.rod.api.user.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/users")
@Slf4j
public class UserController {

    private final UserServiceImpl service;
    private final UserRepository repo;


    //커맨드
    @PostMapping("")
    public ResponseEntity<Messenger> join(@RequestBody Map<?, ?> paramMap){
//        Map<String, Messenger> map = new HashMap<>();
//        User newUser = repo.save(User.builder()
//                .username((String) paramMap.get("username"))
//                .password((String) paramMap.get("password"))
//                .name((String) paramMap.get("name"))
//                .phone((String) paramMap.get("phone"))
//                .job((String) paramMap.get("job"))
//                .build());
//        log.info("DB 에 저장된 User 정보 : {}", newUser);

        return ResponseEntity.ok(new Messenger());
    }


//쿼리

    @PostMapping("/login")
    public ResponseEntity<Messenger> login(@RequestBody Map<?, ?> paramMap){
//        Map<String, MessengerVo> map = new HashMap<>();
//        String username = (String) paramMap.get("username");
//        log.info("리퀘스트가 가져온 이름 : {}", username);
//        String password = (String) paramMap.get("password");
//        log.info("리퀘스트가 가져온 비번 : {}", password);
//        User dbUser = repo.findByUsername(username).orElse(null);



        return ResponseEntity.ok(new Messenger());
    }


//    @SuppressWarnings("unchecked")
    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> findAll(){
//        Map<String, Object> map = new HashMap<>();
//        @SuppressWarnings("unchecked")
//        List<User> list = service.findAll();
//        list.forEach(System.out::println);
//        System.out.println("리스트 사이즈 : "+list.size());
//        map.put("result", list);
//        log.info("입력받은 정보 : {}");
        return ResponseEntity.ok(service.findAll());
    }


}
