package com.example.checkin.model.response;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImportResponse {
    private List<?> listSuccess;
    private List<?> listError;
}
