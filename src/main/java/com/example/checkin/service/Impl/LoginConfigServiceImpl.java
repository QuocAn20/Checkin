package com.example.checkin.service.Impl;

import com.example.checkin.mapper.LoginConfigMapper;
import com.example.checkin.model.request.LoginConfigRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.LoginConfigResponse;
import com.example.checkin.service.ILoginConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginConfigServiceImpl implements ILoginConfigService {

    @Autowired
    private LoginConfigMapper mapper;

    @Override
    public BaseResponse getLConfig(LoginConfigRequest request) {
        try{
            LoginConfigResponse result = mapper.get(request);

            if(result != null){
                return new BaseResponse(result, "0", "get successfully");
            }else {
                return new BaseResponse("1", "get fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }

    @Override
    public BaseResponse updateLConfig(LoginConfigRequest request) {
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
}
