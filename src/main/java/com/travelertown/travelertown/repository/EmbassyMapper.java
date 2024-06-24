package com.travelertown.travelertown.repository;

import com.travelertown.travelertown.entity.Embassy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmbassyMapper {
    public List<Embassy> getEmbassyByCountryCode(String countryCode);
}
