package com.example.checkin.model.request;

import com.example.checkin.model.dto.Paging;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuggestionRequest extends Paging {
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

    private String fileType;
}
