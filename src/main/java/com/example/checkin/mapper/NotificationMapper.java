package com.example.checkin.mapper;

import com.example.checkin.model.request.NotificationRequest;
import com.example.checkin.model.response.NotificationResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotificationMapper {

    List<NotificationResponse> get(NotificationRequest request);

    NotificationResponse create(NotificationRequest request);
    int countNotification(NotificationRequest request);

    int update(NotificationRequest request);

    int getCode();
}
