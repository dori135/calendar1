package com.example.calendar.controller;


import com.example.calendar.dto.CommentRequestDto;
import com.example.calendar.dto.CommentResponseDto;
import com.example.calendar.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules/{scheduleId}/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // 댓글 생성
    @PostMapping
    public ResponseEntity<CommentResponseDto> createComment(
            @PathVariable Long scheduleId,
            @RequestBody CommentRequestDto requestDto
    ) {
        CommentResponseDto response = commentService.create(scheduleId, requestDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // 댓글 단건 조회
    @GetMapping("/{commentId}")
    public ResponseEntity<CommentResponseDto> findComment(
            @PathVariable Long scheduleId,
            @PathVariable Long commentId
    ) {
        CommentResponseDto comment = commentService.findById(scheduleId, commentId);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    // 특정 schedules의 댓글 전체 조회
    @GetMapping
    public ResponseEntity<List<CommentResponseDto>> findAllComments(@PathVariable Long scheduleId) {
        List<CommentResponseDto> comments = commentService.findAll(scheduleId);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    // 댓글 수정
    @PutMapping("/{commentId}")
    public ResponseEntity<CommentResponseDto> updateComment(
            @PathVariable Long scheduleId,
            @PathVariable Long commentId,
            @RequestBody CommentRequestDto requestDto
    ) {
        CommentResponseDto updated = commentService.update(scheduleId, commentId, requestDto);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // 댓글 삭제
    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(
            @PathVariable Long scheduleId,
            @PathVariable Long commentId
    ) {
        commentService.delete(scheduleId, commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}