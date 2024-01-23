package com.example.checkin.service;

import com.example.checkin.model.request.SuggestionRequest;
import com.example.checkin.model.response.BaseResponse;

import java.io.File;

public interface ISuggestionService {
    BaseResponse getSuggest(SuggestionRequest request);
    BaseResponse getCountSuggest(SuggestionRequest request);

    BaseResponse updateSuggest(SuggestionRequest request);

    BaseResponse createSuggest(SuggestionRequest request);

    File export(SuggestionRequest request);
}
