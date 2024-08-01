package com.travelertown.travelertown.controller.board;

import com.travelertown.travelertown.dto.board.BoardBookmarkReqDto;
import com.travelertown.travelertown.dto.board.NewBoardReqDto;
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

    //게시물 작성
    @PostMapping("/new")
    public ResponseEntity<?> newBoard(@RequestBody NewBoardReqDto newBoardReqDto) {
        return ResponseEntity.ok(boardService.newBoard(newBoardReqDto));
    }

    //게시물 단건 조회
    @GetMapping("/{boardId}")
    public ResponseEntity<?> getBoard(@PathVariable int boardId) {
        return ResponseEntity.ok(boardService.getBoard(boardId));
    }

    //게시물 전체 조회
    @GetMapping("/all")
    public ResponseEntity<?> getBoards(@RequestParam int boardCategoryId) {
        return ResponseEntity.ok().body(boardService.getBoards(boardCategoryId));
    }

    //유저아이디 게시물 전체 조회
    @GetMapping("/allByUserId")
    public ResponseEntity<?> getBoardsByUserId(@RequestParam int userId) {
        System.out.println("들어왔따!!!" + userId);
        return ResponseEntity.ok().body(boardService.getBoardsByUserId(userId));
    }

    //게시물 삭제
    @DeleteMapping("/remove")
    public ResponseEntity<?> removeBoard(@RequestParam int boardId) {
        return ResponseEntity.ok().body(boardService.removeBoard(boardId));
    }

    //게시물 수정
    @PutMapping("/update")
    public ResponseEntity<?> updateBoard(@RequestBody UpdateBoardReqDto updateBoardReqDto) {
        return ResponseEntity.ok(boardService.updateBoard(updateBoardReqDto));
    }

    //게시물 검색(제목 또는 국가)
    @GetMapping("/search")
    public ResponseEntity<?> getBoardsByTitleOrCountryNameKor(@RequestParam int boardCategoryId, @RequestParam String searchText) {
        return ResponseEntity.ok(boardService.getBoardsByTitleOrCountryNameKor(boardCategoryId, searchText));
    }

    //------------------------------------------------------

    //게시물 북마크 추가
    @PostMapping("/bookmark/add")
    public ResponseEntity<?> addBoardBookmarkByBoardId(@RequestBody BoardBookmarkReqDto boardBookmarkReqDto) {
        return ResponseEntity.ok(boardService.addBoardBookmarkByBoardId(boardBookmarkReqDto));
    }

    //게시물 북마크 조회(boardId, userId)
    @GetMapping("/bookmark/get")
    public ResponseEntity<?> getBoardBookmarkByBoardIdAndUserId(@RequestParam int userId, @RequestParam int boardId) {
        return ResponseEntity.ok().body(boardService.getBoardBookmarkByBoardIdAndUserId(userId, boardId));
    }

    //유저 게시물 북마크 조회(userId)
    @GetMapping("/bookmark/getAll")
    public ResponseEntity<?> getBoardBookmarkByUserId(@RequestParam int boardCategoryId, @RequestParam int userId) {
        return ResponseEntity.ok(boardService.getBoardBookmarkByUserId(boardCategoryId, userId));
    }

    //게시물 북마크 제거
    @DeleteMapping("/bookmark/remove")
    public ResponseEntity<?> removeBoardBookmarkByBoardBookmarkId(@RequestParam int boardBookmarkId) {
        return ResponseEntity.ok(boardService.removeBoardBookmarkByBoardIdAndUserId(boardBookmarkId));
    }

    @GetMapping("/bookmark/all")
    public ResponseEntity<?> getBookmarks(@RequestParam int boardId) {
        return ResponseEntity.ok(boardService.getBookmarks(boardId));
    }
}
