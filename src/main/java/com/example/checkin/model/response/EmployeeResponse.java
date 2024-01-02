package com.example.checkin.model.response;

import com.example.checkin.model.dto.Paging;
import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeResponse extends Paging{
    private String id;
    private String code;
    private String name;
    private Date dob;
    private String gender;
    private String room;
    private String position;
    private String status;
    private List<String> role;

    //    create account
    private String accountId;
    private String password;
    private String userName;
}
