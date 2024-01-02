package com.example.checkin.mapper;

import com.example.checkin.model.request.EmployeeRequest;
import com.example.checkin.model.response.UserResponse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserResponse createEmployeeAccount(EmployeeRequest request);

    UserResponse finAccountByUsername(String userName);

    UserResponse checkUsernameExistion(String userName);
}
