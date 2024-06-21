package com.travelertown.travelertown.dto.country;

import com.travelertown.travelertown.entity.CountryBookmark;
import lombok.Data;

@Data
public class AddCountryBookmarkReqDto {
    private String  countryCode;

    public CountryBookmark toEntity() {
        return CountryBookmark.builder()
                .countryCode(countryCode)
                .build();
    }
}
