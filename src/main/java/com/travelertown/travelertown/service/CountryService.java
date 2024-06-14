package com.travelertown.travelertown.service;

import com.travelertown.travelertown.entity.Country;
import com.travelertown.travelertown.repository.CountryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {

    @Autowired
    private CountryMapper countryMapper;

    public List<Country> getCountryAll() {
        return countryMapper.getCountryAll();
    }
}
