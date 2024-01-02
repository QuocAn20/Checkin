package com.example.checkin.model.response;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
public class BaseResponse {
    private Object data;

    private String errorCode = null;
    private String errorDesc = null;
    private long totalRecord;

    public BaseResponse() {
        this.data = null;
        this.errorDesc = null;
        this.errorCode = null;
    }

    public BaseResponse(Object data) {
        this.data = data;
    }

    public BaseResponse(String errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public BaseResponse(Object data, String errorCode, String errorDesc) {
        this.data = data;
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public BaseResponse(Object data, int totalRecord, String errorCode, String errorDesc) {
        this.data = data;
        this.totalRecord = totalRecord;
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }
}


