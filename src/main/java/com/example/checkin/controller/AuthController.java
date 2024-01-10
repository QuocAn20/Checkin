package com.example.checkin.controller;

import com.example.checkin.contant.Constants;
import com.example.checkin.model.request.CheckInOutRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.UserResponse;
import com.example.checkin.service.ICheckInOutService;
import com.example.checkin.service.IUserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.message.AuthException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ICheckInOutService checkInOutService;

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, Object> user) throws AuthException {
        String userName = (String) user.get("username");
        String password = (String) user.get("password");

        if(userName == null || password == null) {
            throw new AuthException("Invalid user/password");
        }

        UserResponse response = userService.validateUser(userName, password);

        if(response == null) {
            Map<String, Object> map = new HashMap<>();;
            map.put("response", null);

            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST );
        }
        return new ResponseEntity<>(generateJWTToken(response), HttpStatus.OK);
    }

    private Map<String, Object> generateJWTToken(UserResponse user) {
        long timestamp = System.currentTimeMillis();
        String token = Jwts.builder().signWith(SignatureAlgorithm.HS512, Constants.API_SECRET_KEY)
                .setIssuedAt(new Date(timestamp))
                .setExpiration(new Date(timestamp + Constants.TOKEN_VALIDITY))
                .claim("name", user.getName())
                .claim("id", user.getId())
                .claim("role", user.getRole())
                .compact();
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("user", user);
        return map;
    }
}
