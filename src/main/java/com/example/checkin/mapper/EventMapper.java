package com.example.checkin.mapper;

import com.example.checkin.model.request.EventRequest;
import com.example.checkin.model.response.EventResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EventMapper {
    List<EventResponse> get(EventRequest request);

    EventResponse create(EventRequest request);
    int countEvent(EventRequest request);

    int update(EventRequest request);

    int getCode();
}
