package com.example.checkin.model.response;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageResponse {
    private String id;
    private String defaultLanguage;
    private List<String> supportLanguage;
    private String uiLanguage;
    private boolean multiLanguage;

    private String supportLanguageId;
}
