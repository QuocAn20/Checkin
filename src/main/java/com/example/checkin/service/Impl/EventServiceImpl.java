package com.example.checkin.service.Impl;

import com.example.checkin.mapper.EventMapper;
import com.example.checkin.model.request.EventRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.EventResponse;
import com.example.checkin.service.ICommonService;
import com.example.checkin.service.IEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements IEventService {

    @Autowired
    private ICommonService commonService;

    @Autowired
    private EventMapper mapper;

    @Override
    public BaseResponse getEvent(EventRequest request) {
        try{
            List<EventResponse> result = mapper.get(request);
            int countEvent = mapper.countEvent(request);

            if(!result.isEmpty()){
                return new BaseResponse(result, countEvent, "0", "get successfully");
            }else {
                return new BaseResponse("1", "get fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }

    @Override
    public BaseResponse updateEvent(EventRequest request) {
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
    public BaseResponse createEvent(EventRequest request) {
        int index = 0;
        try{
            String code = "E-";
            int getCode = mapper.getCode() + index;
            String pad = commonService.padLeft(String.valueOf(getCode), 4, "0");
            request.setCode(code + pad);

            EventResponse result = mapper.create(request);

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
