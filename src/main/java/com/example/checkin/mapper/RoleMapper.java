package com.example.checkin.mapper;

import com.example.checkin.model.request.EmployeeRequest;
import com.example.checkin.model.response.EmployeeResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleMapper {

    EmployeeResponse create(EmployeeRequest request);

    List<String> get(@Param("id") String id);

    int delete(@Param("id") String id);
}
