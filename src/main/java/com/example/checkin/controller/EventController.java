package com.example.checkin.controller;

import com.example.checkin.model.request.EventRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/event")
public class EventController {

    @Autowired
    private IEventService eventService;

    @PostMapping(value = "/getEvent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getEvent(@RequestBody EventRequest request){
        return new ResponseEntity<>(eventService.getEvent(request), HttpStatus.OK);
    }

    @PostMapping(value = "/createEvent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createEvent(@RequestBody EventRequest request){
        return new ResponseEntity<>(eventService.createEvent(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateEvent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateEvent(@RequestBody EventRequest request){
        return new ResponseEntity<>(eventService.updateEvent(request), HttpStatus.OK);
    }
}
