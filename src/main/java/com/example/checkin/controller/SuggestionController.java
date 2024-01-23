package com.example.checkin.controller;

import com.example.checkin.model.request.CheckInOutRequest;
import com.example.checkin.model.request.RoomRequest;
import com.example.checkin.model.request.SuggestionRequest;
import com.example.checkin.model.response.BaseResponse;
import com.example.checkin.service.ISuggestionService;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@RestController
@CrossOrigin
@RequestMapping(value = "/suggest")
public class SuggestionController {

    @Autowired
    private ISuggestionService suggestionService;

    @PostMapping(value = "/getSuggest", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> getSuggest(@RequestBody SuggestionRequest request){
        return new ResponseEntity<>(suggestionService.getSuggest(request), HttpStatus.OK);
    }

    @PostMapping(value = "/createSuggest", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> createSuggest(@RequestBody SuggestionRequest request){
        return new ResponseEntity<>(suggestionService.createSuggest(request), HttpStatus.OK);
    }

    @PostMapping(value = "/updateSuggest", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseResponse> updateSuggest(@RequestBody SuggestionRequest request){
        return new ResponseEntity<>(suggestionService.updateSuggest(request), HttpStatus.OK);
    }

    @PostMapping(value = "/export", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<InputStreamResource> export(@RequestBody SuggestionRequest request) {
        try {
            File file = suggestionService.export(request);
            if (file == null) {
                throw new ServiceException("Nothing to export");
            }
            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
            return ResponseEntity.ok().headers(new HttpHeaders()).contentLength(file.length())
                    .contentType(MediaType.parseMediaType("application/" + request.getFileType())).body(resource);
        } catch (FileNotFoundException e) {
            throw new ServiceException("Failed");
        }
    }
}
