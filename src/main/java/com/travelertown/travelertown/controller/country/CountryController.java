package com.travelertown.travelertown.controller.country;

import com.travelertown.travelertown.aop.annotation.ValidAspect;
import com.travelertown.travelertown.dto.country.AddCountryBookmarkReqDto;
import com.travelertown.travelertown.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/bookmark")
    public ResponseEntity<?> addCountryBookmark(@RequestBody AddCountryBookmarkReqDto addCountryBookmarkReqDto) {
        System.out.println(addCountryBookmarkReqDto);
        return ResponseEntity.ok().body(countryService.addCountryBookmark(addCountryBookmarkReqDto));
    }

    @GetMapping("/getbookmark")
    public ResponseEntity<?> getCountryBookmarkByUserId() {
        return ResponseEntity.ok().body(countryService.getCountryBookmarkByUserId());
    }

    @DeleteMapping("/removebookmark")
    public ResponseEntity<?> removeCountryBookmarkByBookmarkId(@RequestParam int countryBookmarkId) {
        return ResponseEntity.ok().body(countryService.removeCountryBookmarkByBookmarkId(countryBookmarkId));
    }

    @GetMapping("/getcountry")
    public ResponseEntity<?> getCountryNameKorAndCountryCodeAll() {
        return ResponseEntity.ok(countryService.getCountryNameKorAndCountryCodeAll());
    }
}
