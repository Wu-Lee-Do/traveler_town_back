package com.travelertown.travelertown.controller.country;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryController {

    @GetMapping("/all")
    public ResponseEntity<?> getCountryAll() {
        return ResponseEntity.ok().body(null);
    }
}
