package com.example.checkin.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkTimeResponse {
    private String id;
    private String startTime;
    private String endTime;
    private String workDayId;
    private String freeDayId;

    private List<String> workDay;
    private List<String> freeDay;
}
