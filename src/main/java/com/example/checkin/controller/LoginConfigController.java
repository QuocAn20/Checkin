package com.example.checkin.controller;

import com.example.checkin.model.request.LoginConfigRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.service.ILoginConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/lconfig")
public class LoginConfigController {

    @Autowired
    private ILoginConfigService loginConfigService;

    @PostMapping(value = "/getLConfig", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getLConfig(@RequestBody LoginConfigRequest request){
        return new ResponseEntity<>(loginConfigService.getLConfig(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateLConfig", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateLConfig(@RequestBody LoginConfigRequest request){
        return new ResponseEntity<>(loginConfigService.updateLConfig(request), HttpStatus.OK);
    }
}
