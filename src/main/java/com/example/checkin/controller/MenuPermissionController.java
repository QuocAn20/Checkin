package com.example.checkin.controller;

import com.example.checkin.model.request.MenuPermissionRequest;
import com.example.checkin.model.request.MenuRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/decentral")
public class MenuPermissionController {

    @Autowired
    private IPermissionService permissionService;

    @PostMapping(value = "/getDecentral", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getMenu(@RequestBody MenuPermissionRequest request){
        return new ResponseEntity<>(permissionService.getMenuPer(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateDecentral", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateDecentral(@RequestBody MenuPermissionRequest request){
        return new ResponseEntity<>(permissionService.updateMenuPer(request), HttpStatus.OK);
    }
}
