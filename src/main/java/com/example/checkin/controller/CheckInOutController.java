package com.example.checkin.controller;

import com.example.checkin.model.request.CheckInOutRequest;
import com.example.checkin.model.request.EmployeeRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.service.ICheckInOutService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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

    @PostMapping(value = "/export", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<InputStreamResource> export(@RequestBody CheckInOutRequest request) {
        try {
            File file = checkInOutservice.export(request);
            if (file == null) {
                throw new ServiceException("Nothing to export");
            }
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok().headers(new HttpHeaders()).contentLength(file.length())
                    .contentType(MediaType.parseMediaType("application/" + request.getFileType())).body(resource);
        } catch (FileNotFoundException e) {
            throw new ServiceException("Failed");
        }
    }
}
