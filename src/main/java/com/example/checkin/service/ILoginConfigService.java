package com.example.checkin.service;

import com.example.checkin.model.request.LoginConfigRequest;
import com.example.checkin.model.response.BaseResponse;

public interface ILoginConfigService {
    BaseResponse getLConfig(LoginConfigRequest request);

    BaseResponse updateLConfig(LoginConfigRequest request);
}
