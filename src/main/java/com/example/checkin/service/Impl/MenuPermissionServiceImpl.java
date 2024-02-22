package com.example.checkin.service.Impl;

import com.example.checkin.mapper.MenuPermissionMapper;
import com.example.checkin.mapper.PermissionMapper;
import com.example.checkin.model.request.MenuPermissionRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.model.response.MenuPermissionResponse;
import com.example.checkin.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MenuPermissionServiceImpl implements IPermissionService {

    @Autowired
    private MenuPermissionMapper mapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public BaseResponse getMenuPer(MenuPermissionRequest request) {
        try {
            List<MenuPermissionResponse> result = mapper.get(request);

            for (MenuPermissionResponse item : result) {
                List<String> listPermission = permissionMapper.getPermission(item.getMenuId());
                if (listPermission.size() > 1) {
                    item.setAdminChecked(true);
                    item.setEmplChecked(true);
                } else {
                    item.setAdminChecked(true);
                }
            }

            return new BaseResponse(result, "0", "get successfully");
        } catch (Exception e) {
            e.fillInStackTrace();
            return new BaseResponse("-1", "fail");
        }
    }

    @Override
    public BaseResponse updateMenuPer(MenuPermissionRequest request) {
        try {
            request.setRoleCode("EMPLOYEE");

            if(request.isEmplChecked()) {
                permissionMapper.createPermission(request.getMenuId(), Collections.singletonList("ADMIN"));
                permissionMapper.createPermission(request.getMenuId(), Collections.singletonList("EMPLOYEE"));
            }else {
                int deleteOldPermission = permissionMapper.deletePermission(request.getMenuId());
                permissionMapper.createPermission(request.getMenuId(), Collections.singletonList("ADMIN"));
            }
            return new BaseResponse( "0", "update successfully");
        } catch (Exception e) {
            e.fillInStackTrace();
            return new BaseResponse("-1", "fail");
        }
    }
}
