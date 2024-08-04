package com.travelertown.travelertown.controller.follow;

import com.travelertown.travelertown.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/add")
    public ResponseEntity<?> follow(@RequestParam int followerId, @RequestParam int followingId){
        return ResponseEntity.ok().body(followService.follow(followerId, followingId));
    }
}
