package com.example.checkin.model.request;

import com.example.checkin.model.dto.Paging;
import lombok.*;
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnitRequest extends Paging {
    private String id;
    private String name;
    private String code;
    private String branch;
    private String note;
    private String status;
}
