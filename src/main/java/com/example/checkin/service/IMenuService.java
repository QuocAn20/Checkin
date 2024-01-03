package com.example.checkin.service;

import com.example.checkin.model.request.MenuRequest;
import com.example.checkin.model.response.BaseResponse;

public interface IMenuService {

    BaseResponse getMenu(MenuRequest request);

    BaseResponse getMenuByRole(MenuRequest request);

    BaseResponse updateMenu(MenuRequest request);

    BaseResponse createMenu(MenuRequest request);

    BaseResponse deleteMenu(MenuRequest request);
}
