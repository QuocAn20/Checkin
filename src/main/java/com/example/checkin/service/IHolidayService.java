package com.example.checkin.service;

import com.example.checkin.model.request.HolidayRequest;
import com.example.checkin.model.response.BaseResponse;

public interface IHolidayService {
    BaseResponse getHoliday(HolidayRequest request);

    BaseResponse updateHoliday(HolidayRequest request);

    BaseResponse createHoliday(HolidayRequest request);
}
