package com.example.checkin.service;

import com.example.checkin.model.request.NotificationRequest;
import com.example.checkin.model.response.BaseResponse;

public interface INotificationService {
    BaseResponse getNotification(NotificationRequest request);

    BaseResponse updateNotification(NotificationRequest request);

    BaseResponse createNotification(NotificationRequest request);
}
