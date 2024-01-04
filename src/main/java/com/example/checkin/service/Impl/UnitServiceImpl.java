package com.example.checkin.service.Impl;

import com.example.checkin.mapper.UnitMapper;
import com.example.checkin.model.request.UnitRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.UnitResponse;
import com.example.checkin.service.ICommonService;
import com.example.checkin.service.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements IUnitService {

    @Autowired
    private UnitMapper mapper;

    @Autowired
    private ICommonService commonService;

    @Override
    public BaseResponse getUnit(UnitRequest request) {
        try{
            List<UnitResponse> result = mapper.get(request);
            int countRoom = mapper.countUnit(request);

            if(!result.isEmpty()){
                return new BaseResponse(result, countRoom, "0", "get successfully");
            }else {
                return new BaseResponse("1", "get fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }

    @Override
    public BaseResponse updateUnit(UnitRequest request) {
        try{
            int result = mapper.update(request);

            if(result > 0){
                return new BaseResponse(result, "0", "create successfully");
            }else {
                return new BaseResponse("1", "create fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }

    @Override
    public BaseResponse createUnit(UnitRequest request) {
        int index = 0;
        try{
            String code = "U-";
            int getCode = mapper.getCode() + index;
            String pad = commonService.padLeft(String.valueOf(getCode), 4, "0");
            request.setCode(code + pad);

            UnitResponse result = mapper.create(request);

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
