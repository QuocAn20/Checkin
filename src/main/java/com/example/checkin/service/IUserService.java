package com.example.checkin.service;

import com.example.checkin.model.request.UserRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.UserResponse;
import org.springframework.web.multipart.MultipartFile;

import javax.security.auth.message.AuthException;
import java.io.File;

public interface IUserService {
    BaseResponse createUser(UserRequest request);

    BaseResponse updateUserPassword(UserRequest request);

    UserResponse validateUser(String userName, String password) throws AuthException;
}
