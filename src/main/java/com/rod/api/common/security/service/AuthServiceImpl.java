package com.rod.api.common.security.service;

import com.rod.api.common.component.Messenger;
import com.rod.api.user.model.User;
import com.rod.api.user.model.UserDto;
import com.rod.api.user.repository.UserRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
@Component
public class AuthServiceImpl implements AuthService {

    private final UserRepository repository;

    public Messenger login(UserDto userDto) {
        boolean flag = repository.findByUsername(userDto.getUsername()).get().getPassword().equals(userDto.getPassword());

        return Messenger.builder()
                .message(flag ? "SUCCESS" : "FAILURE")
                .token(flag ? createToken(userDto) : "None")
                .build();
    }

    @Override
    public String createToken(UserDto userDto) {

        String token = Jwts.builder()
//                .issuer(issuer)
//                .signWith(secretKey)
//                .expiration(Date.from(expiredDate))
                .subject("rod")
                .claim("username", userDto.getUsername())
                .claim("job", userDto.getJob())
                .claim("userId", userDto.getId())

                .compact();


        log.info("로그인 성공으로 발급된 토큰 : "+token);
        return token;
    }

}
