package com.example.checkin.model.response;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginConfigResponse {
    private String id;
    private int timeInLogin;
    private int limitLogin;
    private int limitLoginWrong;
    private int timeLoginAgain;
}
