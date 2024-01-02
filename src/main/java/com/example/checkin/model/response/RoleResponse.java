package com.example.checkin.model.response;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleResponse {
    private String id;
    private String employeeId;
    private String serviceId;
}
