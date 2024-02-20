package com.example.checkin.service.Impl;

import com.example.checkin.mapper.RegisterMapper;
import com.example.checkin.model.request.RegisterRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.RegisterResponse;
import com.example.checkin.service.ICommonService;
import com.example.checkin.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements IRegisterService {

    @Autowired
    private RegisterMapper mapper;

    @Autowired
    private ICommonService commonService;

    @Override
    public BaseResponse getRegister(RegisterRequest request) {
        try{
            List<RegisterResponse> result = mapper.get(request);
            int countRegister = mapper.countRegister(request);

            if(result != null){
                return new BaseResponse(result, countRegister, "0", "get successfully");
            }else {
                return new BaseResponse("1", "get fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }

    @Override
    public BaseResponse updateRegister(RegisterRequest request) {
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
    public BaseResponse deleteRegister(RegisterRequest request) {
        try{
            int result = mapper.delete(request);

            if(result > 0){
                return new BaseResponse(result, "0", "delete successfully");
            }else {
                return new BaseResponse("1", "delete fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }

    @Override
    public BaseResponse createRegister(RegisterRequest request) {
        int index = 0;
        try{
            String code = "RG-";
            int getCode = mapper.getCode() + index;
            String pad = commonService.padLeft(String.valueOf(getCode), 4, "0");
            request.setCode(code + pad);

            RegisterResponse result = mapper.create(request);

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
