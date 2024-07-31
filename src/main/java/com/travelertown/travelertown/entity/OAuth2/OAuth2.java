package com.travelertown.travelertown.entity.OAuth2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OAuth2 {
    private int oAuth2Id;
    private String oAuth2Name;
    private int userId;
    private String providerName;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
