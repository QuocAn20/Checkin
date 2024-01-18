package com.example.checkin.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LanguageRequest {
    private String id;
    private String defaultLanguage;
    private List<String> supportLanguage;
    private String uiLanguage;
    private boolean multiLanguage;

    private String supportLanguageId;
}
