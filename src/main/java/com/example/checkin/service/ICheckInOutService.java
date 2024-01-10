package com.example.checkin.service;

import com.example.checkin.model.request.CheckInOutRequest;
import com.example.checkin.model.response.BaseResponse;

public interface ICheckInOutService {
    BaseResponse getCheckInOut(CheckInOutRequest request);

    BaseResponse updateCheckInOut(CheckInOutRequest request);

    BaseResponse createCheckInOut(CheckInOutRequest request);
}
