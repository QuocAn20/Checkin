package com.example.checkin.service;

import com.example.checkin.model.request.EventRequest;
import com.example.checkin.model.response.BaseResponse;

public interface IEventService {
    BaseResponse getEvent(EventRequest request);

    BaseResponse updateEvent(EventRequest request);

    BaseResponse createEvent(EventRequest request);
}
