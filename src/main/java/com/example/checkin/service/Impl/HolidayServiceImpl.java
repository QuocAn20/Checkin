package com.example.checkin.service.Impl;

import com.example.checkin.mapper.HolidayMapper;
import com.example.checkin.model.request.HolidayRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.HolidayResponse;
import com.example.checkin.service.ICommonService;
import com.example.checkin.service.IHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayServiceImpl implements IHolidayService {

    @Autowired
    private HolidayMapper mapper;

    @Autowired
    private ICommonService commonService;

    @Override
    public BaseResponse getHoliday(HolidayRequest request) {
        try{
            List<HolidayResponse> result = mapper.get(request);
            int countHoliday = mapper.countHoliday(request);

            if(result != null){
                return new BaseResponse(result, countHoliday, "0", "get successfully");
            }else {
                return new BaseResponse("1", "get fail");
            }
        }catch (Exception e){
            return new BaseResponse("-1", "fail");
        }
    }

    @Override
    public BaseResponse updateHoliday(HolidayRequest request) {
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
    public BaseResponse createHoliday(HolidayRequest request) {
        int index = 0;
        try{
            String code = "H-";
            int getCode = mapper.getCode() + index;
            String pad = commonService.padLeft(String.valueOf(getCode), 4, "0");
            request.setCode(code + pad);

            HolidayResponse result = mapper.create(request);

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
