package com.example.checkin.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuPermissionResponse {
    private String menuId;
    private String menuName;
    private boolean adminChecked;
    private boolean emplChecked;
    private String creator;
}
