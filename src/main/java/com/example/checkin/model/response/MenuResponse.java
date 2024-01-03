package com.example.checkin.model.response;

import com.example.checkin.model.dto.Paging;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class MenuResponse {
    private String id;
    private String name;
    private String path;
    private String icon;
    private String creator;
    private List<String> roleCode;
}
