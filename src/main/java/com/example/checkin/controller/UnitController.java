package com.example.checkin.controller;

import com.example.checkin.model.request.UnitRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.service.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/unit")
public class UnitController {

    @Autowired
    private IUnitService unitService;

    @PostMapping(value = "/getUnit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getUnit(@RequestBody UnitRequest request){
        return new ResponseEntity<>(unitService.getUnit(request), HttpStatus.OK);
    }

    @PostMapping(value = "/createUnit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createUnit(@RequestBody UnitRequest request){
        return new ResponseEntity<>(unitService.createUnit(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateUnit", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateUnit(@RequestBody UnitRequest request){
        return new ResponseEntity<>(unitService.updateUnit(request), HttpStatus.OK);
    }

}
