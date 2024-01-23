package com.example.checkin.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SuggestionResponse {
    private String id;
    private String code;
    private String name;
    private String createDate;
    private String creatorId;
    private String creator;
    private String room;
    private String suggestion;
    private String reply;
    private String note;
    private String status;
}
