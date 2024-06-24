package com.travelertown.travelertown.controller.country;

import com.travelertown.travelertown.service.EmbassyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/embassy")
public class EmbassyController {

    @Autowired
    private EmbassyService embassyService;

    @GetMapping("/single")
    public ResponseEntity<?> getEmbassyByCountryCode(@RequestParam String countryCode) {
        return ResponseEntity.ok().body(embassyService.getEmbassyByCountryCode(countryCode));
    }

}
