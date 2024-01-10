package com.example.checkin.controller;

import com.example.checkin.model.request.RoomRequest;
import com.example.checkin.model.request.WaitingScreenRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.service.IWaitingScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/wscreen")
public class WaitingScreenController {

    @Autowired
    private IWaitingScreenService wscreenService;

    @PostMapping(value = "/getWScreen", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getWScreen(@RequestBody WaitingScreenRequest request){
        return new ResponseEntity<>(wscreenService.getWScreen(request), HttpStatus.OK);
    }

    @PostMapping(value = "/createWScreen", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createWScreen(@RequestBody WaitingScreenRequest request){
        return new ResponseEntity<>(wscreenService.createWScreen(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateWScreen", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateWScreen(@RequestBody WaitingScreenRequest request){
        return new ResponseEntity<>(wscreenService.updateWScreen(request), HttpStatus.OK);
    }
}
