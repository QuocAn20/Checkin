package com.example.checkin.mapper;

import com.example.checkin.model.request.WaitingScreenRequest;
import com.example.checkin.model.response.WaitingScreenResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WaitingScreenMapper {
    List<WaitingScreenResponse> get(WaitingScreenRequest request);

    WaitingScreenResponse create(WaitingScreenRequest request);
    int countWScreen(WaitingScreenRequest request);

    int update(WaitingScreenRequest request);

    int updateStatus(WaitingScreenRequest request);

    int getCode();
}
