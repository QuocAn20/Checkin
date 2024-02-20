package com.example.checkin.mapper;

import com.example.checkin.model.request.EmployeeRequest;
import com.example.checkin.model.request.UserRequest;
import com.example.checkin.model.response.UserResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    UserResponse createEmployeeAccount(EmployeeRequest request);

    UserResponse getUser(UserRequest request);

    int updateUserPassword(UserRequest request);
    int updateUserPasswordWithUSName(UserRequest request);

    UserResponse finAccountByUsername(String userName);

    UserResponse checkUsernameExisted(String userName);

    int checkExistedEmail(@Param("email") String email);

    int checkExistedUser(String userName);

}
