package com.example.checkin.service.Impl;

import com.example.checkin.mapper.SurveyMapper;
import com.example.checkin.model.request.SurveyRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.SurveyResponse;
import com.example.checkin.service.ICommonService;
import com.example.checkin.service.ISurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyServiceImpl implements ISurveyService {

    @Autowired
    private SurveyMapper mapper;

    @Autowired
    private ICommonService commonService;

    @Override
    public BaseResponse getSurvey(SurveyRequest request) {
        try{
            List<SurveyResponse> result = mapper.get(request);
            int countSurvey = mapper.countSurvey(request);

            if(result != null){
                return new BaseResponse(result, countSurvey, "0", "get successfully");
            }else {
                return new BaseResponse("1", "get fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }

    @Override
    public BaseResponse updateSurvey(SurveyRequest request) {
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
    public BaseResponse deleteSurvey(SurveyRequest request) {
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
    public BaseResponse createSurvey(SurveyRequest request) {
        int index = 0;
        try{
            String code = "S-";
            int getCode = mapper.getCode() + index;
            String pad = commonService.padLeft(String.valueOf(getCode), 4, "0");
            request.setCode(code + pad);

            SurveyResponse result = mapper.create(request);

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
