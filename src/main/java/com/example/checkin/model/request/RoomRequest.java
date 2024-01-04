package com.example.checkin.model.request;

import com.example.checkin.model.dto.Paging;
import lombok.*;
import org.hibernate.type.StringNVarcharType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomRequest extends Paging {
    private String id;
    private String room;
    private String code;
    private String branch;
    private String note;
    private String status;
}
