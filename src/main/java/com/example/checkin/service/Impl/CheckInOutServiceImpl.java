package com.example.checkin.service.Impl;

import com.example.checkin.mapper.CheckInOutMapper;
import com.example.checkin.mapper.EmployeeMapper;
import com.example.checkin.model.request.CheckInOutRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.CheckInOutResponse;
import com.example.checkin.service.ICheckInOutService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckInOutServiceImpl implements ICheckInOutService {

    @Autowired
    private CheckInOutMapper mapper;

    @Autowired
    private EmployeeMapper emplMapper;

    @Override
    public BaseResponse getCheckInOut(CheckInOutRequest request) {
        try{
            List<CheckInOutResponse> result = mapper.get(request);
            int countCheckInOut = mapper.countCheckInOut(request);

            if(!result.isEmpty()){
                return new BaseResponse(result, countCheckInOut, "0", "get successfully");
            }else {
                return new BaseResponse("1", "get fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }

    @Override
    public BaseResponse updateCheckInOut(CheckInOutRequest request) {
        try{
            String getEmployeeId = emplMapper.getEmployeeIdByAccountId(request.getId());
            request.setEmployeeId(getEmployeeId);

            List<CheckInOutResponse> listCheckOutById = mapper.getCheckOutById(request);
            for(CheckInOutResponse item : listCheckOutById){
                if(Strings.isNullOrEmpty(item.getCheckOut())
                    && Strings.isNullOrEmpty((item.getWorkTime()))
                ){
                    int result = mapper.updateCheckOut(item.getId());
                    int result1 = mapper.updateTime(item.getId(), request.getStatus());
                    if(result > 0){
                        return new BaseResponse(result, "0", "update successfully");
                    }else {
                        return new BaseResponse("1", "update fail");
                    }
                }
            }
            return null;

        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }

    @Override
    public BaseResponse createCheckInOut(CheckInOutRequest request) {
        try{
            String getEmployeeId = emplMapper.getEmployeeIdByAccountId(request.getId());
            request.setEmployeeId(getEmployeeId);

            CheckInOutResponse result = mapper.create(request);

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
