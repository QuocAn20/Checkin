package com.example.checkin.mapper;

import com.example.checkin.model.request.SurveyRequest;
import com.example.checkin.model.response.SurveyResponse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SurveyMapper {

    SurveyResponse create (SurveyRequest request);

    List<SurveyResponse> get (SurveyRequest request);

    int update (SurveyRequest request);

    int delete (SurveyRequest request);

    int countSurvey (SurveyRequest request);

    int getCode();
}
