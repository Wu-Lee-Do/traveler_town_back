package com.travelertown.travelertown.controller.country;

import com.travelertown.travelertown.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/all")
    public ResponseEntity<?> getCountryAll() {
        return ResponseEntity.ok().body(countryService.getCountryAll());
    }

    @GetMapping("/single")
    public ResponseEntity<?> getCountry(@RequestParam String search) {
        return ResponseEntity.ok().body(countryService.getCountry(search));
    }
}
