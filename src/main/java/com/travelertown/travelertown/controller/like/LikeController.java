package com.travelertown.travelertown.controller.like;

import com.travelertown.travelertown.dto.like.NewLikeReqDto;
import com.travelertown.travelertown.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/like")
public class LikeController {
    @Autowired
    LikeService likeService;

    @PostMapping("/new")
    public ResponseEntity<?> newLike(@RequestBody NewLikeReqDto newLikeReqDto) {
        return ResponseEntity.ok(likeService.newLike(newLikeReqDto));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getLikes(@RequestParam int boardId) {
        return ResponseEntity.ok(likeService.getLikes(boardId));
    }

    @GetMapping("/likeBoardAll")
    public ResponseEntity<?> getLikeBoardsByUserId(@RequestParam int userId) {
        System.out.println("들어옴?????");
        return ResponseEntity.ok().body(likeService.getLikeBoardsByUserId(userId));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeLike(@RequestParam int boardLikeId) {
        return ResponseEntity.ok(likeService.removeLike(boardLikeId));
    }
}
