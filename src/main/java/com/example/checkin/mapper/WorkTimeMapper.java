package com.example.checkin.mapper;

import com.example.checkin.model.request.WorkTimeRequest;
import com.example.checkin.model.response.WorkTimeResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WorkTimeMapper {
    List<WorkTimeResponse> get(WorkTimeRequest request);
    int update(WorkTimeRequest request);
}
