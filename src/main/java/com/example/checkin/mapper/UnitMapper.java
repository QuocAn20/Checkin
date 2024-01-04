package com.example.checkin.mapper;

import com.example.checkin.model.request.UnitRequest;
import com.example.checkin.model.response.UnitResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UnitMapper {
    List<UnitResponse> get(UnitRequest request);

    UnitResponse create(UnitRequest request);
    int countUnit(UnitRequest request);

    int update(UnitRequest request);

    int getCode();
}
