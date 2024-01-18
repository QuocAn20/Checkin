package com.example.checkin.controller;

import com.example.checkin.model.request.LanguageRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.service.ILanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/language")
public class LanguageController {

    @Autowired
    private ILanguageService languageService;

    @PostMapping(value = "/getLanguage", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getLanguage(@RequestBody LanguageRequest request){
        return new ResponseEntity<>(languageService.getLanguage(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateLanguage", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateLanguage(@RequestBody LanguageRequest request){
        return new ResponseEntity<>(languageService.updateLanguage(request), HttpStatus.OK);
    }

}
