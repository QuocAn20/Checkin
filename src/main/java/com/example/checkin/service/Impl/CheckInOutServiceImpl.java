package com.example.checkin.service.Impl;

import com.example.checkin.mapper.CheckInOutMapper;
import com.example.checkin.mapper.EmployeeMapper;
import com.example.checkin.model.request.CheckInOutRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.CheckInOutResponse;
import com.example.checkin.service.ICheckInOutService;
import com.example.checkin.utils.ExportUtil;
import com.google.common.base.Strings;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

            if(result != null){
                return new BaseResponse(result, countCheckInOut, "0", "get successfully");
            }else {
                return new BaseResponse("1", "get fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }

    @Override
    public BaseResponse getCountLate(CheckInOutRequest request) {
        try{
            Map<String, List<Integer>> result = new HashMap<>();
            List<Integer> resultCountLate = new ArrayList<>();

            String[] monthList = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};

            for(String month :monthList){
                int data = mapper.countLateCheckIn(month);
                resultCountLate.add(data);
            }

            result.put("countLate", resultCountLate);

            return new BaseResponse(result, "0", "get successfully");
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
                    request.setCheckIn(item.getCheckIn());

                    if(result > 0){

                        int updateTime = mapper.updateTime(item.getId(), request.getStatus()
                                , request.getStartTime(), request.getEndTime());

                        if(updateTime > 0){
                            return new BaseResponse(result, "0", "update successfully");
                        }
                    }else {
                        return new BaseResponse("1", "update fail");
                    }
                }
            }
            return new BaseResponse("1", "update fail");

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

    @Override
    public File export(CheckInOutRequest request) {
        File file;
        try {
            file = File.createTempFile("out", ".tmp");
            file.deleteOnExit();
            Resource resource = new ClassPathResource("templates/export-checkin.jasper");
            try (FileOutputStream fos = new FileOutputStream(file);
                 InputStream inputStream = resource.getInputStream()) {
                List<CheckInOutResponse> list = mapper.get(request);
                if (!list.isEmpty()) {
                    list.add(0, new CheckInOutResponse());
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
