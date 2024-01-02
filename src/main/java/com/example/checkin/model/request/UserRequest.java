package com.example.checkin.model.request;

import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    private String id;
    private String name;
    private String userName;
    private String password;
    private String role;
}
