package com.example.checkin.model.response;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponse {
    private String id;
    private String name;
    private String code;
    private String branch;
    private String note;
    private String status;
}
