package com.example.checkin.controller;

import com.example.checkin.model.request.RegisterRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/register")
public class RegisterController {

    @Autowired
    private IRegisterService RegisterService;

    @PostMapping(value = "/getRegister", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getRegister(@RequestBody RegisterRequest request){
        return new ResponseEntity<>(RegisterService.getRegister(request), HttpStatus.OK);
    }

    @PostMapping(value = "/createRegister", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createRegister(@RequestBody RegisterRequest request){
        return new ResponseEntity<>(RegisterService.createRegister(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateRegister", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateRegister(@RequestBody RegisterRequest request){
        return new ResponseEntity<>(RegisterService.updateRegister(request), HttpStatus.OK);
    }

    @PostMapping(value = "/deleteRegister", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> deleteRegister(@RequestBody RegisterRequest request){
        return new ResponseEntity<>(RegisterService.deleteRegister(request), HttpStatus.OK);
    }
}
