package com.example.checkin.service;

import com.example.checkin.model.request.EmployeeRequest;
import com.example.checkin.model.request.RoomRequest;
import com.example.checkin.model.response.BaseResponse;

public interface IRoomService {
    BaseResponse getRoom(RoomRequest request);

    BaseResponse updateRoom(RoomRequest request);

    BaseResponse createRoom(RoomRequest request);
}
