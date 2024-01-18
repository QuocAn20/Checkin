package com.example.checkin.mapper;

import com.example.checkin.model.request.CheckInOutRequest;
import com.example.checkin.model.response.CheckInOutResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CheckInOutMapper {
    List<CheckInOutResponse> get(CheckInOutRequest request);
    CheckInOutResponse create(CheckInOutRequest request);
    int countCheckInOut(CheckInOutRequest request);
    int updateCheckOut (String id);

    int updateTime (@Param("id") String id, @Param("status") String status
            , @Param("startTime") String startTime, @Param("endTime") String endTime);
    List<CheckInOutResponse> getCheckOutById (CheckInOutRequest request);
}
