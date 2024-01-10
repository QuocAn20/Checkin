package com.example.checkin.model.request;

import com.example.checkin.model.dto.Paging;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventRequest extends Paging {
    private String id;
    private String code;
    private String name;
    private String status;
    private String note;
    private String startDate;
    private String endDate;
    private String startTime;
    private String endTime;
}
