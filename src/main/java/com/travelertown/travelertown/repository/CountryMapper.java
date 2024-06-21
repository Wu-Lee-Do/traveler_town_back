package com.travelertown.travelertown.repository;

import com.travelertown.travelertown.entity.Country;
import com.travelertown.travelertown.entity.CountryBookmark;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CountryMapper {
    public List<Country> getCountryAll();
    public Country getCountry(String search);
    public int addCountryBookmark(CountryBookmark countryBookmark);
}
