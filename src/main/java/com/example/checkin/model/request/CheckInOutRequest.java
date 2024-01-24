package com.example.checkin.model.request;

import com.example.checkin.model.dto.Paging;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CheckInOutRequest extends Paging {
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

    //export
    private String fileType;
    private String startTime;
    private String endTime;

    private int countLate;
    private String month;
}
