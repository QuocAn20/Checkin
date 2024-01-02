package com.example.checkin.model.dto;

import lombok.*;

@Getter
@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paging {
    private int page;
    private int limit;
}
