package com.example.checkin.mapper;

import com.example.checkin.model.request.LoginConfigRequest;
import com.example.checkin.model.response.LoginConfigResponse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginConfigMapper {
    LoginConfigResponse get(LoginConfigRequest request);

    int update(LoginConfigRequest request);
}
