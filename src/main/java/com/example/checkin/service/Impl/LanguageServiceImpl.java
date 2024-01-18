package com.example.checkin.service.Impl;

import com.example.checkin.mapper.LanguageMapper;
import com.example.checkin.mapper.LanguagePermissionMapper;
import com.example.checkin.model.request.LanguageRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.LanguageResponse;
import com.example.checkin.service.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageServiceImpl implements ILanguageService {

    @Autowired
    private LanguageMapper mapper;

    @Autowired
    private LanguagePermissionMapper languagePermissionMapper;

    @Override
    public BaseResponse getLanguage(LanguageRequest request) {
        try{
             List<LanguageResponse> result = mapper.get(request);

            for(LanguageResponse item : result){
                List<String> listLanguagePermission = languagePermissionMapper.getLanguagePermission(item.getSupportLanguageId());
                if(listLanguagePermission != null){
                    item.setSupportLanguage(listLanguagePermission);
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
    public BaseResponse updateLanguage(LanguageRequest request) {
        try{
            int deleteLanguage = languagePermissionMapper.deleteLanguagePermission(request.getSupportLanguageId());

            int result = mapper.update(request);

            if(result > 0){
                languagePermissionMapper.createLanguagePermission(request.getSupportLanguageId(), request.getSupportLanguage());
                return new BaseResponse(result, "0", "update successfully");
            }else {
                return new BaseResponse("1", "update fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }
}
