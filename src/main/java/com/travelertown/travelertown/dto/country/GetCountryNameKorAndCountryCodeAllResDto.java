package com.travelertown.travelertown.dto.country;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetCountryNameKorAndCountryCodeAllResDto {
    private String countryCode;
    private String countryNameKor;
}
