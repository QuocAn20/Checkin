package com.example.checkin.mapper;

import com.example.checkin.model.request.EmployeeRequest;
import com.example.checkin.model.response.EmployeeResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeResponse create(EmployeeRequest request);

    List<EmployeeResponse> getEmployee(EmployeeRequest request);

    List<EmployeeResponse> getEmployeeByRole(EmployeeRequest request);

    String getEmployeeIdByAccountId(String id);

    List<EmployeeResponse> getAll();

    int update(EmployeeRequest request);

    int delete(EmployeeRequest request);

    int countEmployee(EmployeeRequest request);

    int checkInfo(EmployeeRequest request);

    String getAccountId(String employeeId);

    int getId();
}
