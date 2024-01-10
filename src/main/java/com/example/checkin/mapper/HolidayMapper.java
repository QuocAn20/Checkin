package com.example.checkin.mapper;

import com.example.checkin.model.request.HolidayRequest;
import com.example.checkin.model.request.RoomRequest;
import com.example.checkin.model.response.HolidayResponse;
import com.example.checkin.model.response.RoomResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface HolidayMapper {

    List<HolidayResponse> get(HolidayRequest request);

    HolidayResponse create(HolidayRequest request);
    int countHoliday(HolidayRequest request);

    int update(HolidayRequest request);

    int getCode();
}
