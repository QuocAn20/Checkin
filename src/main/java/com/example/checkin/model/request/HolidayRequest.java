package com.example.checkin.model.request;

import com.example.checkin.model.dto.Paging;
import lombok.*;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HolidayRequest extends Paging {
    private String id;
    private String name;
    private String code;
    private String date;
    private String note;
    private String status;
}
