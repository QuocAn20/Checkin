package com.example.checkin.model.response;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HolidayResponse{
    private String id;
    private String name;
    private String code;
    private String date;
    private String note;
    private String status;
}
