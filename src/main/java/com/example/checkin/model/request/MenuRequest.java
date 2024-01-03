package com.example.checkin.model.request;

import com.example.checkin.model.dto.Paging;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class MenuRequest extends Paging {
    private String id;
    private String name;
    private String path;
    private String icon;
    private String creator;
    private int numerate;
    private List<String> roleCode;
}
