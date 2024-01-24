package com.example.checkin.model.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class CheckInOutResponse {
    private String id;
    private String code;
    private String name;
    private String room;
    private String unit;
    private String date;
    private String checkIn;
    private String checkOut;
    private String workTime;
    private String late;
    private String soon;
    private String status;
    private String employeeId;

    private String startTime;
    private String endTime;

    private int countLate;
    private String month;
}
