package com.example.checkin.service.Impl;

import com.example.checkin.mapper.WaitingScreenMapper;
import com.example.checkin.model.request.WaitingScreenRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.WaitingScreenResponse;
import com.example.checkin.service.ICommonService;
import com.example.checkin.service.IWaitingScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class WaitingScreenServiceImpl implements IWaitingScreenService {

    @Autowired
    private WaitingScreenMapper mapper;

    @Autowired
    private ICommonService commonService;

    @Override
    public BaseResponse getWScreen(WaitingScreenRequest request) {
        try{
            List<WaitingScreenResponse> result = mapper.get(request);

            int countWScreen = mapper.countWScreen(request);

            if(result != null){
                return new BaseResponse(result, countWScreen, "0", "get successfully");
            }else {
                return new BaseResponse("1", "get fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }

    @Override
    public BaseResponse updateWScreen(WaitingScreenRequest request) {
        try{
            if(Objects.equals(request.getStatus(), "Default")){
                int updateStatus = mapper.updateStatus(request);
            }

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
    public BaseResponse createWScreen(WaitingScreenRequest request) {
        int index = 0;
        try{
            String code = "WS-";
            int getCode = mapper.getCode() + index;
            String pad = commonService.padLeft(String.valueOf(getCode), 4, "0");
            request.setCode(code + pad);

            if(Objects.equals(request.getStatus(), "Default")){
                int updateStatus = mapper.updateStatus(request);
            }

            WaitingScreenResponse result = mapper.create(request);

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
