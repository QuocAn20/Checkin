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
    private String questionType;
    private Date createDate;
}
