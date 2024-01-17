package com.example.checkin.controller;

import com.example.checkin.model.request.PassConfigRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.service.IPassConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/pass-config")
public class PassConfigController {

    @Autowired
    private IPassConfigService passConfigService;

    @PostMapping(value = "/getPassConfig", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getLConfig(@RequestBody PassConfigRequest request){
        return new ResponseEntity<>(passConfigService.getPassConfig(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updatePassConfig", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updatePassConfig(@RequestBody PassConfigRequest request){
        return new ResponseEntity<>(passConfigService.updatePassConfig(request), HttpStatus.OK);
    }
}
