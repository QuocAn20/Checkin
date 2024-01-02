package com.example.checkin.model.response;

import com.example.checkin.model.dto.Paging;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserResponse extends Paging {
    private String id;
    private String name;
    private String userName;
    private String password;
    private String role;
}
