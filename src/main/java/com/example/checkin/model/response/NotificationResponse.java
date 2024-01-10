package com.example.checkin.model.response;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationResponse {
    private String id;
    private String code;
    private String notiType;
    private String content;
    private String object;
    private String notiPlace;
    private String status;
    private String note;
}
