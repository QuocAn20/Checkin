package com.example.checkin.service.Impl;

import com.example.checkin.mapper.NotificationMapper;
import com.example.checkin.model.request.NotificationRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.NotificationResponse;
import com.example.checkin.service.ICommonService;
import com.example.checkin.service.INotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements INotificationService {

    @Autowired
    private ICommonService commonService;

    @Autowired
    private NotificationMapper mapper;

    @Override
    public BaseResponse getNotification(NotificationRequest request) {
        try{
            List<NotificationResponse> result = mapper.get(request);
            int countNotifi = mapper.countNotification(request);

            if(result != null){
                return new BaseResponse(result, countNotifi, "0", "get successfully");
            }else {
                return new BaseResponse("1", "get fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }

    @Override
    public BaseResponse updateNotification(NotificationRequest request) {
        try{
            int result = mapper.update(request);

            if(result > 0){
                return new BaseResponse(result, "0", "update successfully");
            }else {
                return new BaseResponse("1", "update fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }

    @Override
    public BaseResponse createNotification(NotificationRequest request) {
        int index = 0;
        try{
            String code = "NT-";
            int getCode = mapper.getCode() + index;
            String pad = commonService.padLeft(String.valueOf(getCode), 4, "0");
            request.setCode(code + pad);

            NotificationResponse result = mapper.create(request);

            if(result != null){
                return new BaseResponse(result, "0", "create successfully");
            }else {
                return new BaseResponse("1", "create fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }
}
