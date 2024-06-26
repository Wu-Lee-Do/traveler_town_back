package com.travelertown.travelertown.controller.board;

import com.travelertown.travelertown.dto.board.NewBoardReqDto;
import com.travelertown.travelertown.dto.board.NewBoardReqDtoEx;
import com.travelertown.travelertown.dto.board.UpdateBoardReqDto;
import com.travelertown.travelertown.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/new")
    public ResponseEntity<?> newBoard(@RequestBody NewBoardReqDto newBoardReqDto) {
        return ResponseEntity.ok(boardService.newBoard(newBoardReqDto));
    }

    @GetMapping("/{boardId}")
    public ResponseEntity<?> getBoard(@PathVariable int boardId) {
        return ResponseEntity.ok(boardService.getBoard(boardId));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getBoards(@RequestParam int boardCategoryId) {
        return ResponseEntity.ok().body(boardService.getBoards(boardCategoryId));
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeBoard(@RequestParam int boardId) {
        return ResponseEntity.ok().body(boardService.removeBoard(boardId));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateBoard(@RequestBody UpdateBoardReqDto updateBoardReqDto) {
        return ResponseEntity.ok(boardService.updateBoard(updateBoardReqDto));
    }

    @GetMapping("/search")
    public ResponseEntity<?> getBoardsByTitleOrCountryNameKor(@RequestParam int boardCategoryId, @RequestParam String searchText) {
        return ResponseEntity.ok(boardService.getBoardsByTitleOrCountryNameKor(boardCategoryId, searchText));
    }
}
