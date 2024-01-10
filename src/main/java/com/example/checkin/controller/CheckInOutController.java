package com.example.checkin.controller;

import com.example.checkin.model.request.CheckInOutRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.service.ICheckInOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/in-out")
public class CheckInOutController {

    @Autowired
    private ICheckInOutService checkInOutservice;

    @PostMapping(value = "/getInOut", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getInOut(@RequestBody CheckInOutRequest request){
        return new ResponseEntity<>(checkInOutservice.getCheckInOut(request), HttpStatus.OK);
    }

    @PostMapping(value = "/createInOut", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createInOut(@RequestBody CheckInOutRequest request){
        return new ResponseEntity<>(checkInOutservice.createCheckInOut(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateInOut", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateInOut(@RequestBody CheckInOutRequest request){
        return new ResponseEntity<>(checkInOutservice.updateCheckInOut(request), HttpStatus.OK);
    }
}
