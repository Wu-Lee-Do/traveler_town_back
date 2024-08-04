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
public class Follow {
    private int followerId;
    private int followingId;
    private LocalDateTime createDate;
}
