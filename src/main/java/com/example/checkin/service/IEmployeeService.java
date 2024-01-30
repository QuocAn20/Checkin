package com.example.checkin.service;

import com.example.checkin.model.request.EmployeeRequest;
import com.example.checkin.model.response.BaseResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface IEmployeeService {
    BaseResponse getEmployee(EmployeeRequest request);

    BaseResponse getAllEmployee(EmployeeRequest request);

    BaseResponse updateEmployee(EmployeeRequest request);

    BaseResponse deleteEmployee(EmployeeRequest request);

    BaseResponse createEmployee(EmployeeRequest request);

    BaseResponse upload(@Param("file") MultipartFile file);
}
