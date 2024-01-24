package com.example.checkin.service;

import com.example.checkin.model.request.CheckInOutRequest;
import com.example.checkin.model.response.BaseResponse;

import java.io.File;

public interface ICheckInOutService {
    BaseResponse getCheckInOut(CheckInOutRequest request);

    BaseResponse getCountLate(CheckInOutRequest request);

    BaseResponse updateCheckInOut(CheckInOutRequest request);

    BaseResponse createCheckInOut(CheckInOutRequest request);

    File export(CheckInOutRequest request);
}
