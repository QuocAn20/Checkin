package com.example.checkin.service;

import com.example.checkin.model.request.LanguageRequest;
import com.example.checkin.model.response.BaseResponse;

public interface ILanguageService {
    BaseResponse getLanguage(LanguageRequest request);

    BaseResponse updateLanguage(LanguageRequest request);
}
