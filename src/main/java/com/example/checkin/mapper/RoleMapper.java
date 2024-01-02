package com.example.checkin.mapper;

import com.example.checkin.model.request.EmployeeRequest;
import com.example.checkin.model.response.EmployeeResponse;
import jakarta.websocket.server.PathParam;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {

    EmployeeResponse create(EmployeeRequest request);

    List<String> get(@PathParam("id") String id);

    int delete(@PathParam("id") String id);
}
