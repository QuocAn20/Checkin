package com.example.checkin.mapper;

import com.example.checkin.model.request.RoomRequest;
import com.example.checkin.model.response.EmployeeResponse;
import com.example.checkin.model.response.RoomResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {
    List<RoomResponse> get(RoomRequest request);

    List<RoomResponse> getAll();

    RoomResponse create(RoomRequest request);
    int countRoom(RoomRequest request);

    int update(RoomRequest request);

    int getCode();
}
