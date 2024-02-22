package com.example.checkin.service;

import com.example.checkin.model.request.MenuPermissionRequest;
import com.example.checkin.model.request.MenuRequest;
import com.example.checkin.model.response.BaseResponse;

public interface IPermissionService {
    BaseResponse getMenuPer(MenuPermissionRequest request);

    BaseResponse updateMenuPer(MenuPermissionRequest request);

}
