package com.example.checkin.service;

import com.example.checkin.model.request.EmployeeRequest;
import com.example.checkin.model.response.BaseResponse;

import java.io.File;

public interface IEmployeeService {
    BaseResponse getEmployee(EmployeeRequest request);

    BaseResponse getAllEmployee(EmployeeRequest request);

    BaseResponse updateEmployee(EmployeeRequest request);

    BaseResponse deleteEmployee(EmployeeRequest request);

    BaseResponse createEmployee(EmployeeRequest request);

}
