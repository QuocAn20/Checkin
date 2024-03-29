package com.example.checkin.controller;

import com.example.checkin.model.request.UserRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping(value = "/createUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createUser(@RequestBody UserRequest request) {
        return new ResponseEntity<>(userService.createUser(request), HttpStatus.OK);
    }

    @PostMapping(value = "/changedPassword", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateUserPassword(@RequestBody UserRequest request) {
        return new ResponseEntity<>(userService.updateUserPassword(request), HttpStatus.OK);
    }

    @PostMapping(value = "/forgotPassword", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> forgotPassword(@RequestBody UserRequest request) {
        return new ResponseEntity<>(userService.forgotPassword(request), HttpStatus.OK);
    }
}
