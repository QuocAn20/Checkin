package com.example.checkin.controller;

import com.example.checkin.model.request.HolidayRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.service.IHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/holiday")
public class HolidayController {

    @Autowired
    private IHolidayService holidayService;

    @PostMapping(value = "/getHoliday", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getHoliday(@RequestBody HolidayRequest request){
        return new ResponseEntity<>(holidayService.getHoliday(request), HttpStatus.OK);
    }

    @PostMapping(value = "/createHoliday", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createHoliday(@RequestBody HolidayRequest request){
        return new ResponseEntity<>(holidayService.createHoliday(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateHoliday", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateHoliday(@RequestBody HolidayRequest request){
        return new ResponseEntity<>(holidayService.updateHoliday(request), HttpStatus.OK);
    }
}
