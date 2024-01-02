package com.example.checkin.model.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleRequest {
    private String id;
    private String employeeId;
    private String serviceId;
}
