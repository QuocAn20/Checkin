package com.example.checkin.controller;

import com.example.checkin.model.request.SurveyRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.service.ISurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/survey")
public class SurveyController {

    @Autowired
    private ISurveyService surveyService;

    @PostMapping(value = "/getSurvey", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getSurvey(@RequestBody SurveyRequest request){
        return new ResponseEntity<>(surveyService.getSurvey(request), HttpStatus.OK);
    }

    @PostMapping(value = "/createSurvey", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createSurvey(@RequestBody SurveyRequest request){
        return new ResponseEntity<>(surveyService.createSurvey(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateSurvey", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateSurvey(@RequestBody SurveyRequest request){
        return new ResponseEntity<>(surveyService.updateSurvey(request), HttpStatus.OK);
    }

    @PostMapping(value = "/deleteSurvey", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> deleteSurvey(@RequestBody SurveyRequest request){
        return new ResponseEntity<>(surveyService.deleteSurvey(request), HttpStatus.OK);
    }
}
