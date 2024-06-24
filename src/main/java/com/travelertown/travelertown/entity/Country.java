package com.travelertown.travelertown.entity;

import com.travelertown.travelertown.dto.country.GetCountryNameKorAndCountryCodeAllResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Country {
    private String countryNameKor;
    private String countryNameEng;
    private String countryCode;
    private String capital;
    private int population;
    private String populationExp;
    private int area;
    private String areaExp;
    private String language;
    private String religion;
    private String people;
    private String climate;
    private String founding;

    public GetCountryNameKorAndCountryCodeAllResDto toGetCountryNameKorAndCountryCodeAllResDto() {
        return GetCountryNameKorAndCountryCodeAllResDto.builder()
                .countryCode(countryCode)
                .countryNameKor(countryNameKor)
                .build();
    }
}
