package com.example.checkin.mapper;

import com.example.checkin.model.request.SuggestionRequest;
import com.example.checkin.model.response.SuggestionResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SuggestionMapper {
    SuggestionResponse create (SuggestionRequest request);

    List<SuggestionResponse> get (SuggestionRequest request);

    int update (SuggestionRequest request);

    int countSuggest(SuggestionRequest request);

    int getCode();
}
