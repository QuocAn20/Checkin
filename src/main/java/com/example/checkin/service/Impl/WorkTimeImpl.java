package com.example.checkin.service.Impl;

import com.example.checkin.mapper.DayPermissionMapper;
import com.example.checkin.mapper.WorkTimeMapper;
import com.example.checkin.model.request.WorkTimeRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.WorkTimeResponse;
import com.example.checkin.service.IWorkTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkTimeImpl implements IWorkTimeService {

    @Autowired
    private WorkTimeMapper mapper;

    @Autowired
    private DayPermissionMapper dayPermissionMapper;

    @Override
    public BaseResponse getWorkTime(WorkTimeRequest request) {
        try{
            List<WorkTimeResponse> result = mapper.get(request);

            for(WorkTimeResponse item : result){
                List<String> listDayPermission = dayPermissionMapper.getDayPermission(item.getWorkDayId());
                if(listDayPermission != null){
                    item.setWorkDay(listDayPermission);
                }
                List<String> listDayFreePermission = dayPermissionMapper.getDayPermission(item.getFreeDayId());
                if(listDayFreePermission != null){
                    item.setFreeDay(listDayFreePermission);
                }
            }

            if(!result.isEmpty()){
                return new BaseResponse(result, "0", "get successfully");
            }else {
                return new BaseResponse("1", "get fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }

    @Override
    public BaseResponse updateWorkTime(WorkTimeRequest request) {
        try{
            int deleteWorkDayPermission = dayPermissionMapper.deleteDayPermission(request.getWorkDayId());
            int deleteFreeDayPermission = dayPermissionMapper.deleteDayPermission(request.getFreeDayId());

            int result = mapper.update(request);

            if(result > 0){
                dayPermissionMapper.createDayPermission(request.getWorkDayId(), request.getWorkDay());
                dayPermissionMapper.createDayPermission(request.getFreeDayId(), request.getFreeDay());

                return new BaseResponse(result, "0", "update successfully");
            }else {
                return new BaseResponse("1", "update fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }
}
