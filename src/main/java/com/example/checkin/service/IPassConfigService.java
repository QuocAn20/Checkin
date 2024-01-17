package com.example.checkin.service;

import com.example.checkin.model.request.PassConfigRequest;
import com.example.checkin.model.response.BaseResponse;

public interface IPassConfigService {
    BaseResponse getPassConfig(PassConfigRequest request);

    BaseResponse updatePassConfig(PassConfigRequest request);
}
