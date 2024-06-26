package com.travelertown.travelertown.service;

import com.travelertown.travelertown.dto.country.AddCountryBookmarkReqDto;
import com.travelertown.travelertown.dto.country.GetCountryNameKorAndCountryCodeAllResDto;
import com.travelertown.travelertown.entity.Country;
import com.travelertown.travelertown.entity.CountryBookmark;
import com.travelertown.travelertown.entity.User;
import com.travelertown.travelertown.repository.CountryMapper;
import com.travelertown.travelertown.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private UserMapper userMapper;

    public List<Country> getCountryAll() {
        return countryMapper.getCountryAll();
    }

    public Country getCountry(String search) {
        return countryMapper.getCountry(search);
    }

    public int addCountryBookmark(AddCountryBookmarkReqDto addCountryBookmarkReqDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userMapper.findUserByUsername(authentication.getName());
        CountryBookmark countryBookmark = addCountryBookmarkReqDto.toEntity();
        countryBookmark.setUserId(user.getUserId());
        return countryMapper.addCountryBookmark(countryBookmark);
    }

    public List<CountryBookmark> getCountryBookmarkByUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = userMapper.findUserByUsername(authentication.getName());
        return countryMapper.getCountryBookmarkByUserId(user.getUserId());
    }

    public int removeCountryBookmarkByBookmarkId(int countryBookmarkId) {
        return countryMapper.removeCountryBookmarkByBookmarkId(countryBookmarkId);
    }

    public List<GetCountryNameKorAndCountryCodeAllResDto> getCountryNameKorAndCountryCodeAll() {
        return countryMapper.getCountryNameKorAndCountryCodeAll().stream().map(Country::toGetCountryNameKorAndCountryCodeAllResDto).collect(Collectors.toList());
    }
}
