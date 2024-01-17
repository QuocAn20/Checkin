package com.example.checkin.service;

import com.example.checkin.model.request.WorkTimeRequest;
import com.example.checkin.model.response.BaseResponse;

public interface IWorkTimeService {
    BaseResponse getWorkTime (WorkTimeRequest request);
    BaseResponse updateWorkTime (WorkTimeRequest request);
}
