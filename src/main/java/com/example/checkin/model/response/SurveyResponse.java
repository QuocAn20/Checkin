package com.example.checkin.model.response;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class SurveyResponse {
    private String id;
    private String code;
    private String name;
    private String createDate;
    private String question;
    private String questionType;
    private String objectRequire;
    private String objectNonRequire;
    private String startTime;
    private String endTime;
    private String percent;
    private String status;
    private String note;
}
