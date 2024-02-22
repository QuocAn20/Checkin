package com.example.checkin.mapper;

import com.example.checkin.model.request.MenuPermissionRequest;
import com.example.checkin.model.response.MenuPermissionResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuPermissionMapper {

    List<MenuPermissionResponse> get(MenuPermissionRequest request);
}
