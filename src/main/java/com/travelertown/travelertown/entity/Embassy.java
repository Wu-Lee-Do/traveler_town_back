package com.travelertown.travelertown.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Embassy {
    private int embassyId;
    private String countryNameKor;
    private String countryCode;
    private String concurrentPosition;
    private String type;
    private String embassyName;
    private String latitude;
    private String longitude;
    private String phoneNumber;
    private String callCenterNumber;
    private String freePhoneNumber;
    private String emergencyNumber;
    private String address;
}
