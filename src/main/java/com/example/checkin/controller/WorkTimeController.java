package com.example.checkin.controller;

import com.example.checkin.model.request.WorkTimeRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.service.IWorkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/work-time")
public class WorkTimeController {

    @Autowired
    private IWorkTimeService workTimeService;

    @PostMapping(value = "/getWorkTime", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getWorkTime(@RequestBody WorkTimeRequest request){
        return new ResponseEntity<>(workTimeService.getWorkTime(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateWorkTime", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateWorkTime(@RequestBody WorkTimeRequest request){
        return new ResponseEntity<>(workTimeService.updateWorkTime(request), HttpStatus.OK);
    }

}
