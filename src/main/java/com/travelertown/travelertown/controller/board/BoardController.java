package com.travelertown.travelertown.controller.board;

import com.travelertown.travelertown.dto.board.NewBoardReqDto;
import com.travelertown.travelertown.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/new")
    public ResponseEntity<?> newBoard(@RequestBody  NewBoardReqDto newBoardReqDto) {
        System.out.println(newBoardReqDto);
        return ResponseEntity.ok(boardService.saveBoard(newBoardReqDto));
    }
}
