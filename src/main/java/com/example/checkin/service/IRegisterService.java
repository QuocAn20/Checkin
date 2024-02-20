package com.example.checkin.service;

import com.example.checkin.model.request.RegisterRequest;
import com.example.checkin.model.response.BaseResponse;

public interface IRegisterService {
    BaseResponse getRegister(RegisterRequest request);

    BaseResponse updateRegister(RegisterRequest request);

    BaseResponse deleteRegister(RegisterRequest request);

    BaseResponse createRegister(RegisterRequest request);
}
