package com.example.checkin.service;

import com.example.checkin.model.request.WaitingScreenRequest;
import com.example.checkin.model.response.BaseResponse;

public interface IWaitingScreenService {
    BaseResponse getWScreen(WaitingScreenRequest request);

    BaseResponse updateWScreen(WaitingScreenRequest request);

    BaseResponse createWScreen(WaitingScreenRequest request);
}
