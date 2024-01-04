package com.example.checkin.controller;

import com.example.checkin.model.request.RoomRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    private IRoomService roomService;

    @PostMapping(value = "/getRoom", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getRoom(@RequestBody RoomRequest request){
        return new ResponseEntity<>(roomService.getRoom(request), HttpStatus.OK);
    }

    @PostMapping(value = "/createRoom", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createRoom(@RequestBody RoomRequest request){
        return new ResponseEntity<>(roomService.createRoom(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateRoom", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateRoom(@RequestBody RoomRequest request){
        return new ResponseEntity<>(roomService.updateRoom(request), HttpStatus.OK);
    }
}
