package com.example.checkin.model.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MenuPermissionRequest {
    private String menuId;
    private String menuName;
    private boolean adminChecked;
    private boolean emplChecked;
    private String creator;
}
