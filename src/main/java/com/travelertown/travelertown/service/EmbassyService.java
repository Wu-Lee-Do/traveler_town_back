package com.travelertown.travelertown.service;

import com.travelertown.travelertown.entity.Embassy;
import com.travelertown.travelertown.repository.EmbassyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmbassyService {

    @Autowired
    private EmbassyMapper embassyMapper;

    public List<Embassy> getEmbassyByCountryCode(String countryCode) {
        return embassyMapper.getEmbassyByCountryCode(countryCode);
    }
}
