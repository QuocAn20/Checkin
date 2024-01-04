package com.example.checkin.model.response;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeResponse {
    private String id;
    private String code;
    private String name;
    private Date dob;
    private String gender;
    private String phone;
    private String nationalId;
    private String imgNationalId;
    private byte[] imgNationalIdFile;
    private String unit;
    private String room;
    private String position;
    private String job;
    private String email;
    private String imgProfile;
    private byte[] imgProfileFile;
    private String status;
    private List<String> role;
}
