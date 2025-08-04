package com.example.calendar.service;

import com.example.calendar.dto.CommentRequestDto;
import com.example.calendar.dto.CommentResponseDto;

import java.util.List;

public interface CommentService {
    CommentResponseDto create(Long scheduleId, CommentRequestDto requestDto);
    CommentResponseDto findById(Long scheduleId, Long commentId);
    List<CommentResponseDto> findAll(Long scheduleId);
    CommentResponseDto update(Long scheduleId, Long commentId, CommentRequestDto requestDto);
    void delete(Long scheduleId, Long commentId);
    List<CommentResponseDto> findAllComments();
}
