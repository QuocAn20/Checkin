package com.example.checkin.service.Impl;

import com.example.checkin.mapper.RoomMapper;
import com.example.checkin.model.request.EmployeeRequest;
import com.example.checkin.model.request.RoomRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.EmployeeResponse;
import com.example.checkin.model.response.RoomResponse;
import com.example.checkin.service.ICommonService;
import com.example.checkin.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    private RoomMapper mapper;

    @Autowired
    private ICommonService commonService;

    @Override
    public BaseResponse getRoom(RoomRequest request) {
        try{
            List<RoomResponse> result = mapper.get(request);
            int countRoom = mapper.countRoom(request);

            if(result != null){
                return new BaseResponse(result, countRoom, "0", "get successfully");
            }else {
                return new BaseResponse("1", "get fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }

    @Override
    public BaseResponse updateRoom(RoomRequest request) {
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
    public BaseResponse createRoom(RoomRequest request) {
        int index = 0;
        try{
            String code = "R-";
            int getCode = mapper.getCode() + index;
            String pad = commonService.padLeft(String.valueOf(getCode), 4, "0");
            request.setCode(code + pad);

            RoomResponse result = mapper.create(request);

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
