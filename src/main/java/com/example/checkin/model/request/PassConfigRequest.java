package com.example.checkin.model.request;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassConfigRequest {
    private String id;
    private int minLength;
    private int maxLength;
    private int minChar;
    private int minNum;
    private int minSPChar;
    private int timeOverPass;
}
