package com.example.checkin.model.request;

import com.example.checkin.model.dto.Paging;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class SurveyRequest extends Paging {
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
