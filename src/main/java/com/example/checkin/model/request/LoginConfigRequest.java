package com.example.checkin.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginConfigRequest {
    private String id;
    private int timeInLogin;
    private int limitLogin;
    private int limitLoginWrong;
    private int timeLoginAgain;
}
