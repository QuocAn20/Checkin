package com.example.checkin.controller;

import com.example.checkin.model.request.MenuRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @PostMapping(value = "/getMenu", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getMenu(@RequestBody MenuRequest request){
        return new ResponseEntity<>(menuService.getMenu(request), HttpStatus.OK);
    }

    @PostMapping(value = "/getMenuByRole", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getMenuByRole(@RequestBody MenuRequest request){
        return new ResponseEntity<>(menuService.getMenuByRole(request), HttpStatus.OK);
    }

    @PostMapping(value = "/createMenu", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createMenu(@RequestBody MenuRequest request){
        return new ResponseEntity<>(menuService.createMenu(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateMenu", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateMenu(@RequestBody MenuRequest request){
        return new ResponseEntity<>(menuService.updateMenu(request), HttpStatus.OK);
    }

    @PostMapping(value = "/deleteMenu", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> deleteMenu(@RequestBody MenuRequest request){
        return new ResponseEntity<>(menuService.deleteMenu(request), HttpStatus.OK);
    }
}
