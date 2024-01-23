package com.example.checkin.service;

import com.example.checkin.model.request.SurveyRequest;
import com.example.checkin.model.response.BaseResponse;

public interface ISurveyService {
    BaseResponse getSurvey(SurveyRequest request);

    BaseResponse updateSurvey(SurveyRequest request);

    BaseResponse deleteSurvey(SurveyRequest request);

    BaseResponse createSurvey(SurveyRequest request);
}
