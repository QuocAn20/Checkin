package com.example.checkin.controller;

import com.example.checkin.model.request.EmployeeRequest;
import com.example.checkin.service.IEmployeeService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.checkin.model.response.BaseResponse;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@CrossOrigin
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @PostMapping(value = "/getEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getEmployee(@RequestBody EmployeeRequest request){
        return new ResponseEntity<>(employeeService.getEmployee(request), HttpStatus.OK);
    }

    @PostMapping(value = "/getAllEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getAllEmployee(@RequestBody EmployeeRequest request){
        return new ResponseEntity<>(employeeService.getAllEmployee(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateEmployee(@RequestBody EmployeeRequest request){
        return new ResponseEntity<>(employeeService.updateEmployee(request), HttpStatus.OK);
    }

    @PostMapping(value = "/deleteEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> deleteEmployee(@RequestBody EmployeeRequest request){
        return new ResponseEntity<>(employeeService.deleteEmployee(request), HttpStatus.OK);
    }

    @PostMapping(value = "/createEmployee", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createEmployee(@RequestBody EmployeeRequest request){
        return new ResponseEntity<>(employeeService.createEmployee(request), HttpStatus.OK);
    }

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> upload(@RequestPart("file") MultipartFile file) {
        return new ResponseEntity<>(employeeService.upload(file), HttpStatus.OK);
    }
}
