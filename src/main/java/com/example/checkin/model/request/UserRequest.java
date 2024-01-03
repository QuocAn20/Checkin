package com.example.checkin.model.request;

import com.example.checkin.model.dto.Paging;
import lombok.*;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest extends Paging {
    private String id;
    private String name;
    private String userName;
    private String password;
    private String role;
}
