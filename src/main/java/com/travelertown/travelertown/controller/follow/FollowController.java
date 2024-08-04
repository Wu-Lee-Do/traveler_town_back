package com.travelertown.travelertown.controller.follow;

import com.travelertown.travelertown.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/add")
    public ResponseEntity<?> follow(@RequestParam int followerId, @RequestParam int followingId){
        return ResponseEntity.ok().body(followService.follow(followerId, followingId));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> unFollow(@RequestParam int followerId, @RequestParam int followingId){
        return ResponseEntity.ok().body(followService.unFollow(followerId, followingId));
    }

    @GetMapping("/followers")
    public ResponseEntity<?> getFollowers(@RequestParam int userId){
        return ResponseEntity.ok().body(followService.getFollowers(userId));
    }

    @GetMapping("/followings")
    public ResponseEntity<?> getFollowings(@RequestParam int userId) {
        return ResponseEntity.ok().body(followService.getFollowings(userId));
    }
}
