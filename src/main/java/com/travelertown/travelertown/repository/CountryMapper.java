package com.travelertown.travelertown.repository;

import com.travelertown.travelertown.entity.Country;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CountryMapper {
    public List<Country> getCountryAll();
}
