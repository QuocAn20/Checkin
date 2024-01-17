package com.example.checkin.service.Impl;

import com.example.checkin.mapper.UserMapper;
import com.example.checkin.model.request.UserRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.UserResponse;
import com.example.checkin.service.IUserService;
import com.google.common.base.Strings;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.security.auth.message.AuthException;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public BaseResponse createUser(UserRequest request) {
        try {
            if (request == null || Strings.isNullOrEmpty(request.getName())
                    || Strings.isNullOrEmpty(request.getUserName())
                    || Strings.isNullOrEmpty(request.getPassword())) {
                return new BaseResponse(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                        "Fiels is requried");
            }

            String hashedPassword = BCrypt.hashpw(request.getPassword(), BCrypt.gensalt(10));
            request.setPassword(hashedPassword);
            return null;
        } catch (Exception e) {
            return new BaseResponse("1", "Failure");
        }
    }

    @Override
    public BaseResponse updateUserPassword(UserRequest request) {
        try {
            UserResponse response = mapper.getUser(request);
            if (BCrypt.checkpw(request.getPassword(), response.getPassword())) {
                String hashedPassword = BCrypt.hashpw(request.getNewPassword(), BCrypt.gensalt(10));
                request.setNewPassword(hashedPassword);

                int result = mapper.updateUserPassword(request);

                if (result > 0) {
                    return new BaseResponse(result, "0", "update successfully");
                }
            }
        } catch (Exception e) {
            return new BaseResponse("-1", "fail");
        }
        return new BaseResponse("1", "update fail");
    }

    @Override
    public UserResponse validateUser(String userName, String password) throws AuthException {
        try {
            UserResponse user = mapper.finAccountByUsername(userName);

            if (!BCrypt.checkpw(password, user.getPassword())) {
                return null;
            }
            user.setPassword(null);
            return user;

        } catch (EmptyResultDataAccessException e) {
            throw new AuthException("Invalid username/password");
        }
    }
}
