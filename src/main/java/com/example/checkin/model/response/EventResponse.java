package com.example.checkin.model.response;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventResponse {
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
