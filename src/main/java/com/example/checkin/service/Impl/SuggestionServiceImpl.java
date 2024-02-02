package com.example.checkin.service.Impl;

import com.example.checkin.mapper.SuggestionMapper;
import com.example.checkin.model.request.SuggestionRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.SuggestionResponse;
import com.example.checkin.service.ICommonService;
import com.example.checkin.service.ISuggestionService;
import com.example.checkin.utils.ExportUtil;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SuggestionServiceImpl implements ISuggestionService {

    @Autowired
    private SuggestionMapper mapper;

    @Autowired
    private ICommonService commonService;

    @Override
    public BaseResponse getSuggest(SuggestionRequest request) {
        try{
            List<SuggestionResponse> result = mapper.get(request);
            int countSuggest = mapper.countSuggest(request);

            if(result != null){
                return new BaseResponse(result, countSuggest, "0", "get successfully");
            }else {
                return new BaseResponse("1", "get fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }

    @Override
    public BaseResponse getCountSuggest(SuggestionRequest request) {
        try{
            List<SuggestionResponse> result = mapper.getReport(request);
            int countSuggest = mapper.countSuggest(request);

            if(result != null){
                return new BaseResponse(result, countSuggest, "0", "get successfully");
            }else {
                return new BaseResponse("1", "get fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }

    @Override
    public BaseResponse updateSuggest(SuggestionRequest request) {
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
    public BaseResponse createSuggest(SuggestionRequest request) {
        int index = 0;
        try{
            String code = "SG-";
            int getCode = mapper.getCode() + index;
            String pad = commonService.padLeft(String.valueOf(getCode), 4, "0");
            request.setCode(code + pad);

            SuggestionResponse result = mapper.create(request);

            if(result != null){
                return new BaseResponse(result, "0", "create successfully");
            }else {
                return new BaseResponse("1", "create fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }

    @Override
    public File export(SuggestionRequest request) {
        File file;
        try {
            file = File.createTempFile("out", ".tmp");
            file.deleteOnExit();
            Resource resource = new ClassPathResource("templates/export-feedback.jasper");
            try (FileOutputStream fos = new FileOutputStream(file);
                 InputStream inputStream = resource.getInputStream()) {
                List<SuggestionResponse> list = mapper.getReport(request);
                if (!list.isEmpty()) {
                    list.add(0, new SuggestionResponse());
                }
                Map<String, Object> parameters = new HashMap<>();
                ExportUtil.exportReport(inputStream, fos, parameters, list, "pdf");
            } catch (Exception e) {
                e.fillInStackTrace();
                throw new ServiceException(e.getMessage());
            }
        } catch (Exception e) {
            e.fillInStackTrace();
            throw new ServiceException(e.getMessage());
        }
        return file;
    }
}
