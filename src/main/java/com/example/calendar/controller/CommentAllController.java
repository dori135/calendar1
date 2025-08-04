package com.example.calendar.controller;

import com.example.calendar.dto.CommentResponseDto;
import com.example.calendar.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentAllController {
    private final CommentService commentService;
    public CommentAllController(CommentService commentService) {
        this.commentService = commentService;
    }

    // schedules 상관 없이 댓글 전체 조회
    @GetMapping
    public ResponseEntity<List<CommentResponseDto>> getAll() {
        List<CommentResponseDto> comments = commentService.findAllComments();
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
}
