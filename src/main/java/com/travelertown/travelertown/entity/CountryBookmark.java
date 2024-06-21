package com.travelertown.travelertown.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CountryBookmark {
    private int countryBookmarkId;
    private int userId;
    private String  countryCode;
    private LocalDateTime createDate;
}
