package com.example.checkin.model.request;

import com.example.checkin.model.dto.Paging;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationRequest extends Paging {
    private String id;
    private String code;
    private String notiType;
    private String content;
    private String object;
    private String notiPlace;
    private String status;
    private String note;
}
