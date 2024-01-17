package com.example.checkin.mapper;

import com.example.checkin.model.request.PassConfigRequest;
import com.example.checkin.model.response.PassConfigResponse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PassConfigMapper {
    PassConfigResponse get(PassConfigRequest request);

    int update(PassConfigRequest request);
}
