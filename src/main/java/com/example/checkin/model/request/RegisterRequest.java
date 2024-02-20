package com.example.checkin.model.request;

import com.example.checkin.model.dto.Paging;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class RegisterRequest extends Paging {
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
    private String status;
    private String note;
}
