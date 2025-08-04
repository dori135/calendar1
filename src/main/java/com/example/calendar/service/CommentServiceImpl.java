package com.example.calendar.service;

import com.example.calendar.dto.CommentRequestDto;
import com.example.calendar.dto.CommentResponseDto;
import com.example.calendar.entity.Schedule;
import com.example.calendar.entity.Comment;
import com.example.calendar.repository.ScheduleRepository;
import com.example.calendar.repository.CommentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    public CommentServiceImpl(CommentRepository commentRepository, ScheduleRepository scheduleRepository) {
        this.commentRepository = commentRepository;
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public CommentResponseDto create(Long scheduleId, CommentRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Schedule not found"));

        Comment comment = new Comment(requestDto.getContent(), requestDto.getName(), schedule);
        Comment saved = commentRepository.save(comment);
        return new CommentResponseDto(saved);
    }

    @Override
    public CommentResponseDto findById(Long scheduleId, Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found"));

        if (!comment.getSchedule().getId().equals(scheduleId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Comment does not belong to schedule");
        }

        return new CommentResponseDto(comment);
    }

    @Override
    public List<CommentResponseDto> findAll(Long scheduleId) {
        return commentRepository.findByScheduleId(scheduleId).stream()
                .map(CommentResponseDto::new)
                .toList();
    }

    @Override
    public CommentResponseDto update(Long scheduleId, Long commentId, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found"));

        if (!comment.getSchedule().getId().equals(scheduleId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Comment does not belong to schedule");
        }

        comment.update(requestDto.getContent());
        return new CommentResponseDto(commentRepository.save(comment));
    }

    @Override
    public void delete(Long scheduleId, Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comment not found"));

        if (!comment.getSchedule().getId().equals(scheduleId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Comment does not belong to schedule");
        }

        commentRepository.delete(comment);
    }

    @Override
    public List<CommentResponseDto> findAllComments() {
        return commentRepository.findAll().stream()
                .map(CommentResponseDto::new)
                .toList();
    }
}
