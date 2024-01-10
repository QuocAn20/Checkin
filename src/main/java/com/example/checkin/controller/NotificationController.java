package com.example.checkin.controller;

import com.example.checkin.model.request.NotificationRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/notification")
public class NotificationController {

    @Autowired
    private INotificationService notificationService;

    @PostMapping(value = "/getNotification", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getNotification(@RequestBody NotificationRequest request){
        return new ResponseEntity<>(notificationService.getNotification(request), HttpStatus.OK);
    }

    @PostMapping(value = "/createNotification", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createNotification(@RequestBody NotificationRequest request){
        return new ResponseEntity<>(notificationService.createNotification(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateNotification", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateNotification(@RequestBody NotificationRequest request){
        return new ResponseEntity<>(notificationService.updateNotification(request), HttpStatus.OK);
    }
}
