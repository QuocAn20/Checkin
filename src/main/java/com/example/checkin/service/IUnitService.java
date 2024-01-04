package com.example.checkin.service;

import com.example.checkin.model.request.RoomRequest;
import com.example.checkin.model.request.UnitRequest;
import com.example.checkin.model.response.BaseResponse;

public interface IUnitService {
    BaseResponse getUnit(UnitRequest request);

    BaseResponse updateUnit(UnitRequest request);

    BaseResponse createUnit(UnitRequest request);
}
