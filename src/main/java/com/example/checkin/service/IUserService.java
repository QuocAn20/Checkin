package com.example.checkin.service;

import com.example.checkin.model.request.UserRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.UserResponse;

import javax.security.auth.message.AuthException;

public interface IUserService {
    BaseResponse createUser(UserRequest request);

    UserResponse validateUser(String userName, String password) throws AuthException;
}
