package com.example.checkin.mapper;

import com.example.checkin.model.request.RegisterRequest;
import com.example.checkin.model.response.RegisterResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegisterMapper {

    RegisterResponse create (RegisterRequest request);

    List<RegisterResponse> get (RegisterRequest request);

    int update (RegisterRequest request);

    int delete (RegisterRequest request);

    int countRegister (RegisterRequest request);

    int getCode();
}
